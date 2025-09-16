package com.library.menu;

import com.library.Book;
import com.library.ItemLibrary;
import com.library.Library;
import com.library.util.Util;

import java.util.Scanner;

public class Menu {
    public Library<ItemLibrary> library;
    Util searchProgram;

    public Menu(Library<ItemLibrary> library) {
        this.library = library;
        searchProgram = new Util<>(library);
    }

    public void menuStart() {
        boolean flag = true;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }

            System.out.println("Biblioteca");
            System.out.println("-".repeat(30));

            System.out.println("1. Sou estudante");
            System.out.println("2. Sou professor");
            System.out.println("3- Sair");
            System.out.print("Escolha: ");

            switch (scanner.nextInt()) {
                case 1 -> menuStudent();
                case 2 -> menuTeacher();
                case 3 -> flag = false;
                default -> System.out.println("WIP");
            }
        }
    }

    private void menuStudent() {

        //Notting to implement YET!!
        menuList();

//        boolean flag = true;
//        while (flag) {
//            Scanner scanner = new Scanner(System.in);
//            for (int i = 0; i < 50; i++) {
//                System.out.println();
//            }
//
//            System.out.println("Biblioteca");
//            System.out.println("-".repeat(30));
//
//
//            System.out.println("1- Lista de items");
//            System.out.println("4- Sair");
//            System.out.print("Escolha: ");
//
//            switch (scanner.nextInt()) {
//                case 1 -> System.out.println("WIP");
//                case 2 -> System.out.println("WIP");
//                case 3 -> menuList();
//                case 4 -> flag = false;
//                default -> System.out.println("WIP");
//            }
//        }
    }

    private void menuTeacher() {
        boolean flag = true;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }

            System.out.println("Biblioteca");
            System.out.println("-".repeat(30));

            System.out.println("1. Adicionar item-wip");
            System.out.println("2. Remover item -wip");
            System.out.println("3- Lista de items");
            System.out.println("4- Sair");
            System.out.print("Escolha: ");

            switch (scanner.nextInt()) {
                case 1 -> addItem();
                case 2 -> removeItem();
                case 3 -> menuList();
                case 4 -> flag = false;
                default -> System.out.println("WIP");
            }
        }
    }

    private void removeItem(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do livro para REMOVER: ");
        String title = scanner.nextLine();
        library.removeElement(title);
    }


    private void addItem() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adicionar Item");

        System.out.print("Digite o nome do Livro: ");
        String title = scanner.nextLine();

        System.out.print("Digite o nome do autor: ");
        String author = scanner.nextLine();

        System.out.print("Digite a quantidade de paginas: ");
        int totalPages = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o genero:");
        String genre = scanner.nextLine();

        library.addElements(new Book(title, author, totalPages, genre));

    }

    private void menuList() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
            System.out.println(library);
            System.out.println("1- Listar todos os items");
            System.out.println("2- Ordenar lista de items");
            System.out.println("3- Pesquisar item");
            System.out.println("4- sair");
            System.out.print("Escolha: ");

            switch (scanner.nextInt()) {
                case 1 -> System.out.println(library);
                case 2 -> sort();
                case 3 -> search();
                case 4 -> flag = false;
                default -> System.out.println("Try again");
            }
        }
    }

    private void sort() {
    }

    private void search() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        System.out.println(library);

        while (flag) {
            System.out.println("Escolha o metodo de busca");
            System.out.println("1- Titulo");
            System.out.println("2- Nome autor");
            System.out.println("3- Genero");
            System.out.println("4- Disponiveis para  emprestimo");
            System.out.println("5- Limpar busca");
            System.out.println("6- Sair");
            System.out.print("Escolha:");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {

                case 1 -> {

                    System.out.print("Digite o titulo do livro: ");
                    System.out.println(searchProgram.addToSearch("title",scanner.nextLine()));
                    for (int i = 0; i < 50; i++) {
                        System.out.println();
                    }
                    System.out.println(searchProgram);
                }
                case 2 -> {
                    System.out.print("Digite o Autor do livro: ");
                    searchProgram.addToSearch("author",scanner.nextLine());
                    for (int i = 0; i < 50; i++) {
                        System.out.println();
                    }

                    System.out.println(searchProgram);
                }
                case 3 -> {
                    System.out.print("Digite o Genero do livro: ");
                    searchProgram.addToSearch("genre",scanner.nextLine());
                    for (int i = 0; i < 50; i++) {
                        System.out.println();
                    }

                    System.out.println(searchProgram);
                }
                case 4 -> {
                    System.out.println("Somente livros disponiveis para emprestimo");
                    searchProgram.isAvailable();
                    for (int i = 0; i < 50; i++) {
                        System.out.println();
                    }

                    System.out.println(searchProgram);
                }
                case 5 -> {
                    System.out.print("Limpando parametros de busca: ");
                    searchProgram.clearSearch();
                    for (int i = 0; i < 50; i++) {
                        System.out.println();
                    }

                    System.out.println(searchProgram);
                }
                case 6 -> {
                    flag =false;
                    searchProgram.clearSearch();
                }
                default -> System.out.println("Tente de novo");
            }

        }
    }



}
