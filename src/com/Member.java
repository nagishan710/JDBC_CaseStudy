package com;

import java.sql.*;

class Member {
    private int memberID;
    private String memberName;
    private String memberType;
    private float membershipFees;

    public Member() {
    }

    public Member(int memberID, String memberName, String memberType, float membershipFees) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.memberType = memberType;
        this.membershipFees = membershipFees;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public float getMembershipFees() {
        return membershipFees;
    }

    public void setMembershipFees(float membershipFees) {
        this.membershipFees = membershipFees;
    }

    public void insertMember(Connection conn) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Member (memberid, membername, membertype, membershipfees) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, memberID);
            stmt.setString(2, memberName);
            stmt.setString(3, memberType);
            stmt.setFloat(4, membershipFees);
            stmt.executeUpdate();
            System.out.println("Member inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMemberType(Connection conn, int memberID, String memberType) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE Member SET membertype = ? WHERE memberid = ?");
            stmt.setString(1, memberType);
            stmt.setInt(2, memberID);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Member type updated successfully.");
            } else {
                System.out.println("No member found with the given member ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMembershipFees(Connection conn, int memberID, float membershipFees) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE Member SET membershipfees = ? WHERE memberid = ?");
            stmt.setFloat(1, membershipFees);
            stmt.setInt(2, memberID);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Membership fees updated successfully.");
            } else {
                System.out.println("No member found with the given member ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMember(Connection conn, int memberID) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Member WHERE memberid = ?");
            stmt.setInt(1, memberID);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Member deleted successfully.");
            } else {
                System.out.println("No member found with the given member ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayMembers(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Member");
            System.out.println("MemberID\tMemberName\tMemberType\tMembershipFees");
            while (rs.next()) {
                int id = rs.getInt("memberid");
                String name = rs.getString("membername");
                String type = rs.getString("membertype");
                float fees = rs.getFloat("membershipfees");
                System.out.println(id + "\t\t" + name + "\t\t" + type + "\t\t" + fees);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


