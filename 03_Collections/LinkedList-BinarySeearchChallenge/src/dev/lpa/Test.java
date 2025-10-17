package dev.lpa;

public class Test {
    public static void main(String[] args) {
//
//                // --- TESTANDO MyLinkedList ---
//                System.out.println("=== TESTE MyLinkedList ===");
//                MyLinkedList list = new MyLinkedList(null);
//
//                ListItem item1 = new Node(50);
//                ListItem item2 = new Node(30);
//                ListItem item3 = new Node(70);
//                ListItem item4 = new Node(60);
//                ListItem item5 = new Node(80);
//                ListItem item6 = new Node(50); // duplicado
//
//                System.out.println("Adicionando itens:");
//                list.addItem(item1);
//                list.addItem(item2);
//                list.addItem(item3);
//                list.addItem(item4);
//                list.addItem(item5);
//                System.out.println("Tentando adicionar duplicado: " + list.addItem(item6));
//
//                System.out.println("\nLista completa:");
//                list.traverse(list.getRoot());
//
//                System.out.println("\nRemovendo 30 (início): " + list.removeItem(item2));
//                System.out.println("Removendo 80 (fim): " + list.removeItem(item5));
//                System.out.println("Removendo 60 (meio): " + list.removeItem(item4));
//                System.out.println("Removendo 100 (não existe): " + list.removeItem(new Node(100)));
//
//                System.out.println("\nLista final:");
//                list.traverse(list.getRoot());
//
//                // --- TESTANDO SearchTree ---
//                System.out.println("\n=== TESTE SearchTree ===");
//                SearchTree tree = new SearchTree(null);
//
//                ListItem t1 = new Node(50);
//                ListItem t2 = new Node(30);
//                ListItem t3 = new Node(70);
//                ListItem t4 = new Node(60);
//                ListItem t5 = new Node(80);
//
//                System.out.println("Adicionando itens:");
//                tree.addItem(t1);
//                tree.addItem(t2);
//                tree.addItem(t3);
//                tree.addItem(t4);
//                tree.addItem(t5);
//
////                System.out.println("\nÁrvore (traversal em ordem):");
////                tree.traverse(tree.getRoot());
////
////                System.out.println("\nRemovendo 30 (folha): " + tree.removeItem(t2));
////                System.out.println("Removendo 70 (com filho): " + tree.removeItem(t3));
////                System.out.println("Removendo 50 (root): " + tree.removeItem(t1));
////
////                System.out.println("\nÁrvore final:");
////                tree.traverse(tree.getRoot());
//
//                // --- TESTANDO com Strings ---
//                System.out.println("\n=== TESTE com Strings ===");
//                MyLinkedList stringList = new MyLinkedList(null);
//                stringList.addItem(new Node("banana"));
//                stringList.addItem(new Node("apple"));
//                stringList.addItem(new Node("orange"));
//                stringList.addItem(new Node("kiwi"));
//
//                System.out.println("Lista de strings:");
//                stringList.traverse(stringList.getRoot());
//
//                System.out.println("\nRemovendo 'apple': " + stringList.removeItem(new Node("apple")));
//                System.out.println("Removendo 'banana': " + stringList.removeItem(new Node("banana")));
//                System.out.println("Lista final de strings:");
//                stringList.traverse(stringList.getRoot());

                Node node1 = new Node("50");
                Node node2 = new Node("30");
                Node node3 = new Node("70");
                Node node4 = new Node("20");
                Node node5 = new Node("40");
                Node node6 = new Node("60");
                Node node7 = new Node("80");

                MyLinkedList list = new MyLinkedList(null);

                System.out.println("=== Add Items ===");
                System.out.println(list.addItem(node1)); // true, root
                System.out.println(list.addItem(node2)); // true
                System.out.println(list.addItem(node3)); // true
                System.out.println(list.addItem(node4)); // true
                System.out.println(list.addItem(node5)); // true
                System.out.println(list.addItem(node6)); // true
                System.out.println(list.addItem(node7)); // true
                System.out.println(list.addItem(node3)); // false, duplicate

                System.out.println("\n=== Traverse List ===");
                list.traverse(list.getRoot());

                System.out.println("\n=== Remove Items ===");
                System.out.println(list.removeItem(node1)); // remove root
                System.out.println(list.removeItem(node4)); // remove leaf
                System.out.println(list.removeItem(new Node("999"))); // false, not in list
                System.out.println(list.removeItem(node6)); // remove middle

                System.out.println("\n=== Traverse List After Removals ===");
                list.traverse(list.getRoot());
            }
        }



