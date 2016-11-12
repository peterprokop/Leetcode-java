package com.company;

public class Main {

    public static void main(String[] args) {
	    Solution.addTwoNumbers(new ListNode(5), new ListNode(5));
    }
}

class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

class Solution {
    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode currentNode = new ListNode(0);
        ListNode retVal = currentNode;

        while (l1 != null
                || l2 != null)
        {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }

            System.out.println("sum: " + sum + "carry: " + carry);

            currentNode.val = sum;

            if (l1 == null
                    && l2 == null)
            {
                if carry != 0 {
                    ListNode nextNode = new ListNode(carry);
                    currentNode.next = nextNode;
                }

                return retVal;
            }

            ListNode nextNode = new ListNode(0);
            currentNode.next = nextNode;
            currentNode = nextNode;
        }

        return retVal;
    }
}