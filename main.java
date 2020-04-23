import java.util.*;

class circularLinkedListNode {
    int id;
    int arrivalTimeOfProcess;
    int burstTimeOfProcess;
    boolean isArrived;
    circularLinkedListNode next;

    circularLinkedListNode(int id, int arrivalTimeOfProcess, int burstTimeOfProcess) {
        this.id = id;
        this.arrivalTimeOfProcess = arrivalTimeOfProcess;
        this.burstTimeOfProcess = burstTimeOfProcess;
        this.isArrived = false;
    }
}

class main {
    int Quantum, noOfProcesses;
    int[] arrivalTime;
    int[] burstTime;
    circularLinkedListNode readyQueue;
    int timmer;

    main() {
        timmer = 0;
    }
    public circularLinkedListNode removeProcess(circularLinkedListNode current) {
        circularLinkedListNode temp = readyQueue;
        if (readyQueue.next == readyQueue) {
            return null;
        } else if (current == readyQueue) {
            temp = temp.next;
            while (temp.next != current) {
                temp = temp.next;
            }
            temp.next = current.next;
            current = current.next;
            readyQueue = current;
            return current;
        }
        while (temp.next != current) {
            temp = temp.next;
        }
        temp.next = current.next;
        current = current.next;
        return current;
    }

    public void getStats() {

    }

    public void makeReadyQueue() {
        circularLinkedListNode temp = null;
        for (int i = 0; i < noOfProcesses; i++) {
            circularLinkedListNode newNode = new circularLinkedListNode(i, arrivalTime[i], burstTime[i]);
            if (readyQueue == null) {
                readyQueue = newNode;
                temp = newNode;
                newNode.next = newNode;
            } else {
                temp.next = newNode;
                newNode.next = readyQueue;
                temp = newNode;
            }
        }
    }

    public void gantChart() {
        System.out.println("Each process is running for " + Quantum + " time quantum.\n");
        makeReadyQueue();
        circularLinkedListNode current = readyQueue;
        boolean exexutedFlag = false;
        do {
            int q = Quantum;
            exexutedFlag = false;
            System.out.println("Time : "+timmer+" seconds");
            if(current.arrivalTimeOfProcess <= timmer){
                current.isArrived = true;
            }
            while (current.burstTimeOfProcess > 0 && q > 0 && current.isArrived == true) {
                current.burstTimeOfProcess--;
                q--;
                timmer++;
                exexutedFlag = true;
            }
            if (exexutedFlag == true) {
                System.out.println("Executing Process : " + current.id);
            }else{
                timmer++;
            }
            if (current.burstTimeOfProcess == 0) {
                current = removeProcess(current);
            } else {
                current = current.next;
            }
        } while (current != null);
    }

    public void scan(int response) {
        Scanner scan = new Scanner(System.in);
        if (response == 0) {
            System.out.println();
            System.out.print("Enter time Quantum : ");
            Quantum = scan.nextInt();
            if(Quantum == 0){
                System.out.println("Invalid Input");
                while(Quantum <= 0){
                    System.out.println();
                    System.out.print("Enter time Quantum : ");
                    Quantum = scan.nextInt();
                }
            }
            System.out.print("\nEnter the Number of Processes : ");
            noOfProcesses = scan.nextInt();
            System.out.println();
            arrivalTime = new int[noOfProcesses];
            for (int i = 0; i < noOfProcesses; i++) {
                System.out.print("Enter the arrival time of process " + i + " : ");
                arrivalTime[i] = scan.nextInt();
            }
            System.out.println();
            burstTime = new int[noOfProcesses];
            for (int i = 0; i < noOfProcesses; i++) {
                System.out.print("Enter the burst time of process " + i + " : ");
                burstTime[i] = scan.nextInt();
            }
            System.out.println();
        } else if (response == 1) {
            Random randomInteger = new Random();
            Quantum = randomInteger.nextInt(11) + 1;
            System.out.println("Randomly generated value of Quantum : " + Quantum);
            System.out.println();
            noOfProcesses = randomInteger.nextInt(10) + 1;
            System.out.println("Randomly generated Number of Processes : " + noOfProcesses);
            System.out.println();
            arrivalTime = new int[noOfProcesses];
            for (int i = 0; i < noOfProcesses; i++) {
                arrivalTime[i] = randomInteger.nextInt(6);
                System.out.println("Randomly generated arrival time of process " + i + " : " + arrivalTime[i]);
            }
            System.out.println();
            burstTime = new int[noOfProcesses];
            for (int i = 0; i < noOfProcesses; i++) {
                burstTime[i] = randomInteger.nextInt(10) + 1;
                System.out.println("Randomly generated burst time of process " + i + " : " + burstTime[i]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println(
                "*****************************Welcome to the Round Robin Scheduler*****************************");
        System.out.println();
        System.out.println("Please Enter the details carefully!!");
        System.out.println();
        int response;
        while (true) {
            System.out.print("Do you want to work on custom input(0) or automatic(random)(1) input? : ");
            response = scan.nextInt();
            System.out.println();
            main scheduler = new main();
            scheduler.scan(response);
            scheduler.gantChart();
            scheduler.getStats();
            System.out.print("\nDo you want to continue? (0/1) : ");
            response = scan.nextInt();
            if (response == 0) {
                break;
            } else {
                System.out.println();
                continue;
            }
        }
        System.out.println(
                "\n*****************************Thank you for using the Round Robin Scheduler!!*****************************");
        System.out.println();
        scan.close();
    }
}