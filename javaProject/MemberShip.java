package javaProject;

import java.util.*; //Scanner library

class Member {
    int memNo;
    String memName;
    int age;
    int salary;

    Member(int memNo, String memName, int age, int salary){
        this.memNo = memNo;
        this.memName = memName;
        this.age = age;
        this.salary = salary;

    }

    public String toString(){
        return memNo+" "+memName+" "+age+" "+salary; //constaructor to store each detail of members
    }
    
}

public class MemberShip{

    //binarySearch
    public static boolean binarySearch(ArrayList<Member> Array , int n){

        int left = 0 , right = Array.size() - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;

            if(Array.get(mid).memNo == n ){

                System.out.println(Array.get(mid));
                return true;

            }else if(Array.get(mid).memNo < n){

                left = mid +1;

            }else{

                right = mid - 1;
            }

        }
        return false;

    }

    //insertionSort
    public static void insertionSort(ArrayList<Member> Array) {

        int i, j;

        for (i = 1; i < Array.size(); i++) {
            
            Member M = new Member(0, "",0,0);
            M.memNo = Array.get(i).memNo;
            M.memName = Array.get(i).memName;
            M.age = Array.get(i).age;
            M.salary = Array.get(i).salary;
            j = i;

            while((j > 0) && (Array.get(j - 1).memNo > M.memNo)) {

                Array.set(j,Array.get(j - 1));
                j--;
            }
            Array.set(j,M);
        }
    }

    // Selection Sort
    public static void selectionSort(ArrayList<Member> Array){

        for(int i = 0; i<Array.size(); i++){

            int x = i;
            for(int j = i; j<Array.size(); j++){

                if(Array.get(j).age < Array.get(x).age){
                    x = j;
                }
            }

            Member temp = Array.get(x);
            Array.set(x , Array.get(i));
            Array.set(i , temp);
        }
    }

    public static void main(String[] args) {

        int selectOpt = -1;

        try (Scanner scanInt = new Scanner(System.in)) {    //store integers
            Scanner scanString = new Scanner(System.in);     //store membership number 
            

            ArrayList<Member> arrLst = new ArrayList<Member>();// create collection of members

            ListIterator ListIt = null;
                                    
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("x                                                  x");
                System.out.println("x                  ---WELCOME---                   x");
                System.out.println("x                                                  x");
                System.out.println("x        Space + Enter --> OPEN the system         x");
                System.out.println("x        Enter         --> CLOSE the system        x");
                System.out.println("x                                                  x");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                String key = scanInt.nextLine();
                
                switch (key) {
                    case " ":

                        do {
                        
                        //menu
                            System.out.println(" ");
                            System.out.println("1.INSERT");
                            System.out.println("2.UPDATE");
                            System.out.println("3.DELETE");
                            System.out.println("4.SEARCH");
                            System.out.println("5.DISPLAY");
                            System.out.println("6.SORT");
                            System.out.println("0.EXIT");
                            
                            System.out.println(" ");
                            System.out.print("Enter your choice :    ");
                            System.out.println(" ");
                            selectOpt = scanInt.nextInt();
    
                            switch (selectOpt) {

                            //insert
                                case 1: 
                                    boolean foundInsert = false;

                                    System.out.println(" ");
                                    System.out.println("Enter how many members you want:");
                                    int n = scanInt.nextInt();

                                    for (int i = 0; i < n; i++) {
                                        System.out.println(" ");
                                        System.out.print("Create Membership No          : ");
                                        int memNo = scanInt.nextInt();
    
                                        System.out.print("Enter Member Name             : ");
                                        String memName = scanString.nextLine();
    
                                        System.out.print("Enter Member age              : ");
                                        int age = scanInt.nextInt();

                                        System.out.print("Enter the allocated salary    : ");
                                        int salary = scanInt.nextInt();
    
                                        arrLst.add(new Member(memNo, memName, age, salary)); // inserting inputs into array list
                                        foundInsert = true;
                                    }

                                    if(foundInsert)
                                        System.out.println("-----------------------------------------------");
                                        System.out.println(" ");
                                        System.out.println("Data inserted successfully...!");
                                        System.out.println(" ");
                                        System.out.println("-----------------------------------------------");                                 
                                break;

                            //update
                                case 2: 
                                        boolean foundUpd = false;

                                        System.out.println(" ");
                                        System.out.print("Enter memNo to update:    ");
                                        int memNo = scanInt.nextInt();
                                        System.out.println(" ");

                                        ListIt = arrLst.listIterator();

                                        while(ListIt.hasNext()){

                                            Member m = (Member)ListIt.next();

                                            if(m.memNo == memNo){
                                                System.out.print("Enter new empname     : ");
                                                String memName = scanString.nextLine();
    
                                                System.out.print("Enter new age         : ");
                                                int age = scanInt.nextInt();

                                                System.out.print("Enter the new salary: ");
                                                int salary = scanInt.nextInt();

                                                ListIt.set(new Member(memNo, memName, age, salary));
                                                foundUpd = true;
                                            }
                                        }

                                        if(foundUpd){
                                            System.out.println("-----------------------------------------------");
                                            System.out.println("Data updated successfully...!");
                                            System.out.println("-----------------------------------------------");             
                                        }else{
                                            System.out.println("-----------------------------------------------");
                                            System.out.println("Data not found...!");
                                            System.out.println("-----------------------------------------------");
                                        }
                                break;

                            //delete
                                case 3:
                                        boolean foundDlt = false;

                                        System.out.print("Enter memNo to delete:    ");
                                        int memNo2 = scanInt.nextInt();
                                        System.out.println(" ");

                                        ListIt = arrLst.listIterator();

                                        while(ListIt.hasNext()){

                                            Member m = (Member)ListIt.next();

                                            if(m.memNo == memNo2){

                                                ListIt.remove();
                                                foundDlt = true;
                                            }
                                        }

                                        if(foundDlt){
                                            System.out.println("-----------------------------------------------");
                                            System.out.println("Data deleted successfully...!");
                                            System.out.println("-----------------------------------------------");             
                                        }else{
                                            System.out.println("-----------------------------------------------");
                                            System.out.println("Data not found...!");
                                            System.out.println("-----------------------------------------------");
                                        }
                                break;

                            //search
                                case 4:
                                        boolean foundSrc = true;

                                        System.out.println(" ");
                                        System.out.print("Enter memNo to search:    ");
                                        int memNoSrc = scanInt.nextInt();
                                        System.out.println(" ");
                                        
                                        ListIt = arrLst.listIterator();

                                        while(ListIt.hasNext()){

                                            Member m = (Member)ListIt.next();

                                            if(m.memNo == memNoSrc){

                                                System.out.println("-----------------------------------------------");
                                                insertionSort(arrLst);
                                                foundSrc = binarySearch(arrLst , memNoSrc);
                                                foundSrc = false;
                                                System.out.println("-----------------------------------------------");  
                                            }
                                            
                                        }

                                        if(foundSrc){
                                            System.out.println("-----------------------------------------------");
                                            System.out.println("Data not found...!");
                                            System.out.println("-----------------------------------------------");
                                        }
                                break;

                            //display
                                case 5:
                                    boolean foundDsp = true;

                                    ListIt = arrLst.listIterator();

                                    System.out.println(" ");

                                    while (ListIt.hasNext()){

                                        System.out.println(ListIt.next());
                                        foundDsp = false;
                                    }

                                    if(foundDsp){
                                        System.out.println("-----------------------------------------------");
                                        System.out.println("Data not found...!");
                                        System.out.println("-----------------------------------------------");
                                    }
                                break;

                            //sort
                                case 6:
                                    int sort;

                                    do {
                                        
                                        System.out.println(" ");
                                        System.out.println("1) Sort By Mem Number");
                                        System.out.println("2) Sort By Member Name");
                                        System.out.println("3) Sort By Member Age");
                                        System.out.println("3) Sort By Member Salary"); //Descending Order
                                        System.out.println("0) BACK");
                                        System.out.println(" ");
                                        System.out.print("Enter your choice : ");
                                        System.out.println(" ");

                                        sort = scanInt.nextInt();
                                    
                                        switch (sort) {
                                        //Sort By Membership Number
                                            case 1:
                                                                                           
                                                System.out.println("-----------------------------------------------");

                                                        insertionSort(arrLst);
                                                        ListIt = arrLst.listIterator();

                                                        while (ListIt.hasNext())
                                                            System.out.println(ListIt.next());

                                                System.out.println("-----------------------------------------------");
                                            break;

                                        //Sort By Member Name
                                            case 2:

                                                Collections.sort(arrLst, new Comparator<Member>(){

                                                    public int compare(Member m1, Member m2){

                                                        return m1.memName.compareTo (m2.memName); // Sort in assending Order
                                                    }
                                                });
                                            
                                                System.out.println("-----------------------------------------------");

                                                ListIt = arrLst.listIterator();

                                                while (ListIt.hasNext())
                                                    System.out.println(ListIt.next());

                                                System.out.println("-----------------------------------------------");
                                                    
                                            break;

                                        //Sort By Member Age 
                                            case 3:
                                                
                                                System.out.println("-----------------------------------------------");

                                                    selectionSort(arrLst);
                                                    ListIt = arrLst.listIterator();

                                                    while (ListIt.hasNext())
                                                        System.out.println(ListIt.next());

                                                System.out.println("-----------------------------------------------");
                                            break;

                                        //Sort By Member Salary 
                                            case 4:
                                                
                                                    Collections.sort(arrLst, new Comparator<Member>(){

                                                        public int compare(Member m1, Member m2){

                                                            return m2.salary - m1.salary; // Sort in Descending Order
                                                        }
                                                    });
                                                
                                                    System.out.println("-----------------------------------------------");

                                                    ListIt = arrLst.listIterator();

                                                    while (ListIt.hasNext())
                                                        System.out.println(ListIt.next());

                                                    System.out.println("-----------------------------------------------");
                                            break;

                                        }       
                                            
                                    } while (sort!=0); //back to menu

                                break;
                            }

                        } while (selectOpt!=0); //exit from menu
                        
                    break;
                
                    default:
                        break; //close or exit system

                }
                
            }

        catch (Exception e) {
            System.out.println(" ");
            System.out.println("-----------------------------------------------");
            System.out.println("Something Went Wrong....!");
            System.out.println("-----------------------------------------------");
        }

    } //End of main method

} //End of main class