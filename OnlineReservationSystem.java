import java.util.Scanner;

public class OnlineReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String names[] = new String[150];
        int trainNumber[] = new int[150];
        String classType[] = new String[150];
        String datesOfJourney[] = new String[150];
        String source[] = new String[150];
        String destination[] = new String[150];
        int num = 1200;
        int count = 0;

        boolean isLogin = false;
        String username = "nivi";
        String password = "1234";

        System.out.println("<----------------Welcome to Online Reservation System ---------------->");
        System.out.println("******* LOGIN FORM *******");

        while (!isLogin) {
            System.out.print("Enter your username: ");
            String un = scanner.nextLine();
            System.out.print("Enter your password: \n");
            String pass= scanner.nextLine();

            if (un.equals(username) && pass.equals(password)) {
                isLogin = true;
                System.out.println("Login successful");
                System.out.println("Welcome " + un + "!!");
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }

        while (true) {
            System.out.println("1. Make a reservation");
            System.out.println("2. Cancel a reservation");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int c = scanner.nextInt();
            scanner.nextLine();

            switch (c) {
                case 1:
                    if (count < 100) {
                        System.out.print("Enter your name: ");
                        String name = scanner.nextLine();
                        System.out.println("...Choose Train...\n1.Seven Hills Express\n2.Kacheguda Express\n3.Gurudev Express\n4.Tirumala Express\n5.Rajdhani Express\n6.Sapthagiri Express");
                        System.out.print("Enter train number (1 to 6): ");
                        int tn = scanner.nextInt();
                        scanner.nextLine();
                        String[] trains = {
                                "Seven Hills Express",
                                "Kacheguda Express",
                                "Gurudev Express",
                                "Tirumala Express",
                                "Rajdhani Express",
                                "Sapthagiri Express"
                        };
                        if (tn >= 1 && tn <= trains.length) {
                            String trainName = trains[tn - 1];
                            // Consume the newline character

                            System.out.print("Enter class type: ");
                            String ct = scanner.nextLine();

                            System.out.print("Enter date of journey (yyyy-MM-dd): ");
                            String doj = scanner.nextLine();

                            System.out.print("Enter source: ");
                            String s = scanner.nextLine();

                            System.out.print("Enter destination: ");
                            String d = scanner.nextLine();

                            names[count] = name;
                            trainNumber[count] = tn;
                            classType[count] = ct;
                            datesOfJourney[count] = doj;
                            source[count] = s;
                            destination[count] = d;

                            int pnr = num++;
                            count++;

                            System.out.println("Reservation successful!!");
                            System.out.println("Your Seat is conformed.");
                            System.out.println("Happy Journey!!");
                            System.out.println("Your PNR is " + pnr + " for " + trainName);
                        } else {
                            System.out.println("Invalid train number.");
                        }
                    } else {
                        System.out.println("Sorry, reservations are Completed!");
                    }
                    break;
                case 2:
                    System.out.print("Enter your PNR number: ");
                    int pnrCancel = scanner.nextInt();
                    scanner.nextLine();

                    boolean cancel = false;
                    for (int i = 0; i < count; i++) {
                        if (pnrCancel == (num - 1 - i)) {
                            System.out.println("Reservation found:");
                            System.out.println("Name: " + names[i]);
                            System.out.println("Train Number: " + trainNumber[i]);
                            System.out.println("Class Type: " + classType[i]);
                            System.out.println("Date of Journey: " + datesOfJourney[i]);
                            System.out.println("Source: " + source[i]);
                            System.out.println("Destination: " + destination[i]);
                            System.out.print("Confirm cancellation (y/n): ");
                            String confirmation = scanner.nextLine().trim().toLowerCase();

                            if (confirmation.equals("y")) {
                                for (int j = i; j < count - 1; j++) {
                                    names[j] = names[j + 1];
                                    trainNumber[j] = trainNumber[j + 1];
                                    classType[j] = classType[j + 1];
                                    datesOfJourney[j] = datesOfJourney[j + 1];
                                    source[j] = source[j + 1];
                                    destination[j] = destination[j + 1];
                                }
                                count--;
                                cancel = true;
                                System.out.println("Reservation with PNR " + pnrCancel + " has been canceled.");
                            }
                            break;
                        }
                    }

                    if (!cancel) {
                        System.out.println("Reservation with PNR " + pnrCancel + " is not found.");
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using the Online Reservation System.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
