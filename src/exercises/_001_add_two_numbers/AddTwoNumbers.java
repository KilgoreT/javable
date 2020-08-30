package exercises._001_add_two_numbers;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode first = createNode(1);
        ListNode second = createNode(9, 9);

        System.out.println(printNode(addTwoNumbers(first, second)));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
//        int r1 = l1 != null ? l1.val : 0;
//        int r2 = l2 != null ? l2.val : 0;
//        int sum = r1 + r2;
        int flag = 0;

//        result.next = new ListNode(sum % 10);
//        l1 = l1.next;
//        l2 = l2.next;

        ListNode temp = result;

        while (l1 != null || l2 != null) {
            int r1 = l1 == null ? 0 : l1.val;
            int r2 = l2 == null ? 0 : l2.val;
            int sum = r1 + r2 + flag;
            temp.next = new ListNode(sum % 10);
            flag = sum / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            temp = temp.next;
        }
        if (flag > 0) {
            temp.next = new ListNode(flag);
        }
        return result.next;
    }

    public static ListNode createNode(int... args) {
        if (args.length == 0) return null;

        ListNode node = new ListNode(args[0]);
        ListNode temp = node;

        for (int i = 1; i < args.length; i++) {
            temp.next = new ListNode(args[i]);
            temp = temp.next;
        }

        return node;
    }

    public static String printNode(ListNode node) {
        StringBuilder stringBuilder = new StringBuilder();
        while (node != null) {
            if (node.next != null) {
                stringBuilder.append(node.val + ", ");
            } else {
                stringBuilder.append(node.val);
            }
            node = node.next;
        }
        return stringBuilder.toString();
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
