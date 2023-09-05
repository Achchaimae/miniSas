import  javax.swing.JOptionPane;

public class Menu {

    public void menu(){
        String menu = JOptionPane.showInputDialog("Hello to miniSas Library \n <choose your need> \n\n" +
                "******* Menu ******* \n" +
                "1 : Show the list of books \n" +
                "2 : book management \n" +
                "3 : Search about a book  \n" +
                "4 : borrow a book \n" +
                "5 : return a book\n" +
                "6 : Generate a static reports\n");
        int list = Integer.parseInt(menu);

        switch (list){
            case 1 :
                Book.show();
                break;
            case 2 :
                String list2 = JOptionPane.showInputDialog("what action do you want \n " +
                        "1: add a book\n " +
                        "2 update a book\n" +
                        "3 delete a book\n\n");
                int manag= Integer.parseInt(list2);
                switch (manag){
                    case 1:

                        String title =JOptionPane.showInputDialog("Insert the title of the book");
                        String author = JOptionPane.showInputDialog("Insert the author of the book");
                        String ISBN = JOptionPane.showInputDialog("INsert the ISBN ");
                        String status = JOptionPane.showInputDialog("Insert the status of the book");
                        Book.add(title,author,ISBN, status);

                        break;
                    case 2 :
                        String iSBN =JOptionPane.showInputDialog("Insert the ISBN of the book for update");
                        Book.searchISBN(iSBN);
                        String list3 = JOptionPane.showInputDialog("the you want to update this  \n 1: yes \n 2 : No \n");
                        int YN= Integer.parseInt(list3);
                            switch (YN){
                                case 1:
                                    String title2 =JOptionPane.showInputDialog("Insert the title of the book");
                                    String author2 = JOptionPane.showInputDialog("Insert the author of the book");
                                    String status2 = JOptionPane.showInputDialog("Insert the status of the book");
                                    Book.update(title2,author2,iSBN,status2);
                            }

                        break;
                    case 3 :

                        break;
                    default:
                        System.out.println("Invalid choice");
                }
                break;
            case 3 :
                String serach = JOptionPane.showInputDialog("INsert the title of the book or the author \n");
                Book.search(serach);

                break;
            case 4 :
                JOptionPane.showInputDialog("Insert the ISBN code for borrow ");
                break;
            case 5 :
                JOptionPane.showInputDialog("Insert the ISBN code for the return ");
                break;
            case 6 :
                JOptionPane.showMessageDialog(null, "6");
                break;
            default:
                System.out.println("Invalid choice");

        }



    }



}
