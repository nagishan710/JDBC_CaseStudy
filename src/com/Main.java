package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/AdeptusMechanicus";
        String username = "root";
        String password = "wombat";
        Scanner scanner = new Scanner ( System.in );

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Member member = new Member();

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1) Insert a new member into the table");
                System.out.println("2) Update membership type");
                System.out.println("3) Update membership fees");
                System.out.println("4) Delete membership details");
                System.out.println("5) Display details of all members");
                System.out.println("6) Exit");

                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter Member ID: ");
                        int memberID = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Member Name: ");
                        String memberName = scanner.nextLine();
                        System.out.print("Enter Member Type: ");
                        String memberType = scanner.nextLine();
                        System.out.print("Enter Membership Fees: ");
                        float membershipFees = Float.parseFloat(scanner.nextLine());

                        member.setMemberID(memberID);
                        member.setMemberName(memberName);
                        member.setMemberType(memberType);
                        member.setMembershipFees(membershipFees);

                        member.insertMember(conn);
                        break;

                    case 2:
                        System.out.print("Enter Member ID: ");
                        int updateMemberID = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter New Member Type: ");
                        String updateMemberType = scanner.nextLine();

                        member.updateMemberType(conn, updateMemberID, updateMemberType);
                        break;

                    case 3:
                        System.out.print("Enter Member ID: ");
                        int updateFeesMemberID = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter New Membership Fees: ");
                        float updateMembershipFees = Float.parseFloat(scanner.nextLine());

                        member.updateMembershipFees(conn, updateFeesMemberID, updateMembershipFees);
                        break;

                    case 4:
                        System.out.print("Enter Member ID: ");
                        int deleteMemberID = Integer.parseInt(scanner.nextLine());

                        member.deleteMember(conn, deleteMemberID);
                        break;

                    case 5:
                        member.displayMembers(conn);
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

