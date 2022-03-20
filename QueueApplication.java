import java.util.*;

public class QueueApplication
{
    public static void main(String[] args)
    {
        Queue<Integer> reception= new LinkedList<>();
        Queue<Integer> waiting= new LinkedList<>();
        InterviewQueue interview= new InterviewQueue();
        interview.receptionQueue(reception);
        System.out.println(reception);
        interview.waitingQueue(waiting, reception);
        System.out.println("Candidates in the Waiting hall");
        System.out.println(waiting);
        System.out.println("Candidates in the Reception");
        System.out.println(reception);
        System.out.println();
        interview.interviewRoom(reception, waiting);

    }
}
class InterviewQueue {
    int candidates;
    Scanner sc = new Scanner(System.in);

    //number of candidates in the reception initially
    public void receptionQueue(Queue<Integer> reception)
    {
        System.out.println("Enter the no. of Candidates ");
        candidates = sc.nextInt();
        for (int i = 1; i <= candidates; i++)
        {
            reception.add(i);
        }

    }

    //number of candidates in the waiting hall before starting interview
    public void waitingQueue(Queue<Integer> waiting, Queue<Integer> reception)
    {

        System.out.println("Enter the no. of candidates allowed to the waiting hall");
        int wait_candidates = sc.nextInt();
        for (int i = 1; i <= wait_candidates; i++)
        {
            reception.remove(i);
            waiting.add(i);
        }
    }

    public void interviewRoom(Queue<Integer> reception, Queue<Integer> waiting)
    {
        System.out.println("INTERVIEW STARTS\n");
        //After starting the interview, candidates entering the interview room
        for (int i = 0; i < candidates; i++)
        {
             int interviewperson = waiting.peek();

            System.out.print("Interview Room: " + interviewperson + " IN\n");
            waiting.remove();

            //Removing candidates from the reception and adding to the waiting hall
            if(reception.size() > 0)
            {
//                int temp = reception.remove();
//                waiting.add(temp);
                waiting.add(reception.remove());
                System.out.println("Candidates in the Waiting hall --> " + waiting);
                System.out.println("Candidates in the Reception --> " + reception);
                System.out.println();
            }
            else
            {
                System.out.println("Candidates in the Waiting hall --> " + waiting);
                System.out.println("Candidates in the Reception --> " + reception);
                System.out.println();
            }
            System.out.println(interviewperson + " --> OUT from Interview Room\n");
        }
        System.out.println("INTERVIEW ENDS");
    }
}
