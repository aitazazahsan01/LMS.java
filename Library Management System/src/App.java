import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class App {
    // Image icons for various parts of the UI
    static ImageIcon homepage = new ImageIcon("Menupage.jpg");
    static ImageIcon studenticon = new ImageIcon("student.png");
    static ImageIcon bookicon = new ImageIcon("Book.png");
    static ImageIcon staticsicon = new ImageIcon("Statics.png");
    static ImageIcon issuebookicon = new ImageIcon("issue.png");
    static ImageIcon returnbookicon = new ImageIcon("return.png");
    static ImageIcon logouticon = new ImageIcon("exit.png");
    static ImageIcon totalicon = new ImageIcon("search.png");
    static ImageIcon bgform = new ImageIcon("123456.png");

    // ArrayLists to store student, book, and issued book information
    static ArrayList<Student> studentList = new ArrayList<>(); // ArrayList to store student objects
    static ArrayList<Book> booklist = new ArrayList<>();
    static ArrayList<IssueBookClass> issueBooks = new ArrayList<>();

    public static void main(String[] args) {
        // Add some students
        Student student1 = new Student("S1", "Aitazaz Ahsan", "Nusrat Jabbar", "BESE-29");
        Student student2 = new Student("S2", "Hassan Ali", "Muhammad Munir", "BESE-28");
        Student student3 = new Student("S3", "Saad Safi", "Safi-udin", "BEEE-60");
        Student student4 = new Student("S4", "Saad Ahmed", "Umer Farooq", "BEEE-57");
        studentList.add(student1);  
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

        Book book1 = new Book("B1", "English", "Prof. Nasir Khan");
        Book book2 = new Book("B2", "Urdu", "Prof. Kamran Rasool");
        Book book3 = new Book("B3", "The Forest", "Williams James");
        Book book4 = new Book("B4", "King of Snow", "Shakes Spear");
        booklist.add(book1);
        booklist.add(book2);
        booklist.add(book3);
        booklist.add(book4);

        IssueBookClass issue1 = new IssueBookClass("B1", "S1", "5", "11");
        IssueBookClass issue2 = new IssueBookClass("B2", "S2", "12", "19");
        issueBooks.add(issue1);
        issueBooks.add(issue2);

        // Background and button icons for the login screen
        ImageIcon bg = new ImageIcon("loginbg.png"); // Ensure the path is correct
        ImageIcon loginicon = new ImageIcon("Login.png");
        ImageIcon closeicon = new ImageIcon("cross.png");

        // Labels and text fields for username and password input
        JLabel usernameLabel = new JLabel("UserName");
        usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        usernameLabel.setBounds(680, 300, 100, 40);

        JTextField userField = new JTextField();
        userField.setBounds(800, 320, 130, 20);
        userField.setFont(new Font("Times New Roman", Font.BOLD, 20));

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        passwordLabel.setBounds(680, 360, 100, 40);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(800, 370, 130, 20);
        passField.setFont(new Font("Times New Roman", Font.BOLD, 20));

        // Login and close buttons
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        loginButton.setBounds(680, 450, 120, 40);
        loginButton.setIcon(loginicon);

        JButton closeButton = new JButton("Close");
        closeButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        closeButton.setBounds(850, 450, 120, 40);
        closeButton.setIcon(closeicon);

        // Create a JFrame for the login screen
        JFrame frame = new JFrame();
        frame.setSize(1366, 707);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create a JPanel with the background image for the login screen
        JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null); // Use absolute layout

        // Add components to the panel
        panel.setBounds(0, 0, 1366, 707);
        panel.add(usernameLabel);
        panel.add(passwordLabel);
        panel.add(userField);
        panel.add(passField);
        panel.add(loginButton);
        panel.add(closeButton);

        // Add the panel to the frame
        frame.add(panel);

        // Hardcoded correct username and password
        String correctUsername = "admin";
        String correctPassword = "password";

        // Add action listener for login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == loginButton) {
                    String enteredUsername = userField.getText();
                    String enteredPassword = new String(passField.getPassword());

                    if (enteredUsername.equals(correctUsername) &&
                            enteredPassword.equals(correctPassword)) {
                        // If credentials are correct, navigate to the home page
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                HomePage();
                                frame.dispose(); // Close the login frame
                            }
                        });
                    } else {
                        // Show error message if credentials are incorrect
                        JOptionPane.showMessageDialog(frame, "Invalid username or password", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Add action listener for close button
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }

    // Method to display the home page
    public static void HomePage() {

        // Image icons for various buttons on the home page
        ImageIcon studenticon = new ImageIcon("student.png");
        ImageIcon bookicon = new ImageIcon("Book.png");
        ImageIcon staticsicon = new ImageIcon("Statics.png");
        ImageIcon issuebookicon = new ImageIcon("issue.png");
        ImageIcon returnbookicon = new ImageIcon("return.png");
        ImageIcon logouticon = new ImageIcon("exit.png");

        // Create a JFrame for the home page
        JFrame frame2 = new JFrame();
        frame2.setSize(1366, 768);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLayout(null);

        // Create a JPanel with the background image for the home page
        JPanel panel2 = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(homepage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel2.setLayout(null); // Use absolute layout

        // Button to add a new student
        JButton student = new JButton("New Student");
        student.setFont(new Font("Times New Roman", Font.BOLD, 15));
        student.setBounds(20, 10, 200, 50);
        student.setIcon(studenticon);

        student.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == student) {
                    StudentsInfo(); // Call method to handle student information
                }
            }
        });

        // Button to add a new book
        JButton book = new JButton("New Book");
        book.setFont(new Font("Times New Roman", Font.BOLD, 15));
        book.setBounds(250, 10, 200, 50);
        book.setIcon(bookicon);

        book.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == book) {
                    BooksInfo(); // Call method to handle book information
                }
            }
        });

        // Button to view statistics
        JButton statics = new JButton("Statics");
        statics.setFont(new Font("Times New Roman", Font.BOLD, 15));
        statics.setBounds(500, 10, 200, 50);
        statics.setIcon(staticsicon);
        statics.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == statics) {
                    Statics(); // Call method to view statistics
                }
            }
        });

        // Button to issue a book
        JButton issuebook = new JButton("Issue Book");
        issuebook.setFont(new Font("Times New Roman", Font.BOLD, 15));
        issuebook.setBounds(720, 10, 200, 50);
        issuebook.setIcon(issuebookicon);
        issuebook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == issuebook) {
                    IssueBook(); // Call method to issue a book
                }
            }
        });

        // Button to return a book
        JButton returnbook = new JButton("Return Book");
        returnbook.setFont(new Font("Times New Roman", Font.BOLD, 15));
        returnbook.setBounds(950, 10, 200, 50);
        returnbook.setIcon(returnbookicon);

        returnbook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == returnbook) {
                    ReturnBook(); // Call method to return a book
                }
            }
        });

        // Button to logout
        JButton logout = new JButton("LogOut");
        logout.setFont(new Font("Times New Roman", Font.BOLD, 15));
        logout.setBounds(1190, 10, 150, 50);
        logout.setIcon(logouticon);

        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == logout) {
                    frame2.dispose(); // Close the home page frame
                }
            }
        });

        // Button to view total books and members
        JButton total = new JButton("Total Books & Members");
        total.setFont(new Font("Times New Roman", Font.BOLD, 15));
        total.setBounds(600, 100, 250, 50);
        total.setIcon(totalicon);
        total.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == total) {
                    Total(); // Call method to view total books and members
                }
            }
        });

        // Add components to the panel
        panel2.setBounds(0, 0, 1366, 768);
        panel2.add(student);
        panel2.add(book);
        panel2.add(statics);
        panel2.add(issuebook);
        panel2.add(returnbook);
        panel2.add(logout);
        panel2.add(total);

        // Add the panel to the frame
        frame2.add(panel2);
        frame2.setVisible(true);
    }

    // Method to add student information
    public static void StudentsInfo() {
        // Icons for save and close buttons
        ImageIcon saveicon = new ImageIcon("save.png");
        ImageIcon closeIcon = new ImageIcon("cross.png");

        // Create a JFrame for the student information form
        JFrame frame3 = new JFrame();
        frame3.setSize(700, 450);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setLayout(null);

        // Create a JPanel with the background image for the form
        JPanel panel3 = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bgform.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel3.setLayout(null); // Use absolute layout
        panel3.setBounds(0, 0, 700, 450);

        // Labels and text areas for student ID, name, father's name, and course
        JLabel id = new JLabel("Student ID");
        id.setFont(new Font("Times New Roman", Font.BOLD, 20));
        id.setBounds(180, 80, 100, 30);

        JTextArea idarea = new JTextArea();
        idarea.setFont(new Font("Times New Roman", Font.BOLD, 20));
        idarea.setBounds(350, 80, 200, 30);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Times New Roman", Font.BOLD, 20));
        name.setBounds(180, 120, 100, 30);

        JTextArea namearea = new JTextArea();
        namearea.setFont(new Font("Times New Roman", Font.BOLD, 20));
        namearea.setBounds(350, 120, 200, 30);

        JLabel fname = new JLabel("Father Name");
        fname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        fname.setBounds(180, 160, 120, 30);

        JTextArea fnamearea = new JTextArea();
        fnamearea.setFont(new Font("Times New Roman", Font.BOLD, 20));
        fnamearea.setBounds(350, 160, 200, 30);

        JLabel textcourse = new JLabel("Course");
        textcourse.setFont(new Font("Times New Roman", Font.BOLD, 20));
        textcourse.setBounds(180, 200, 120, 30);

        // Dropdown for selecting course
        String courses[] = { "BESE-29", "BESE-28", "BESE-27", "BESE-26", "BEEE-57", "BEEE-58", "BEEE-59", "BEEE-60",
                "IS-01", "IS-02", "IS-03", "IS-04" };
        JComboBox course = new JComboBox<String>(courses);
        course.setFont(new Font("Times New Roman", Font.BOLD, 20));
        course.setBounds(350, 200, 120, 30);

        // Save button to save student information
        JButton save = new JButton("Save");
        save.setFont(new Font("Times New Roman", Font.BOLD, 20));
        save.setBounds(200, 300, 120, 40);
        save.setIcon(saveicon);

        // Action listener for save button
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get entered student information
                String studentId = idarea.getText();
                String studentName = namearea.getText();
                String fatherName = fnamearea.getText();
                String courseName = (String) course.getSelectedItem();

                // Check if all fields are filled
                if (studentId.isEmpty() || studentName.isEmpty() || fatherName.isEmpty() || courseName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields");
                    return;
                }

                // Check if student ID already exists
                for (Student student : studentList) {
                    if (student.id.equals(studentId)) {
                        JOptionPane.showMessageDialog(null, "Student ID already exists. Please enter a unique ID.");
                        return;
                    }
                }

                // Create a new Student object
                Student newStudent = new Student(studentId, studentName, fatherName, courseName);

                // Add the student to the ArrayList
                studentList.add(newStudent);
                JOptionPane.showMessageDialog(null, "Student Successfully Added!");

                // Clear input fields after saving
                idarea.setText("");
                namearea.setText("");
                fnamearea.setText("");
            }
        });

        // Close button to close the form
        JButton close = new JButton("Close");
        close.setFont(new Font("Times New Roman", Font.BOLD, 20));
        close.setBounds(400, 300, 120, 40);
        close.setIcon(closeIcon);

        // Action listener for close button
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == close) {
                    frame3.dispose(); // Close the student information form
                }
            }
        });

        // Add components to the panel
        panel3.add(id);
        panel3.add(idarea);
        panel3.add(name);
        panel3.add(namearea);
        panel3.add(fname);
        panel3.add(fnamearea);
        panel3.add(textcourse);
        panel3.add(course);
        panel3.add(save);
        panel3.add(close);

        // Add the panel to the frame and display it
        frame3.add(panel3);
        frame3.setBounds(300, 200, 700, 450);
        frame3.setVisible(true);
    }

    // Student class to store student information
    static class Student {
        private String id;
        private String name;
        private String fatherName;
        private String course;

        public Student(String id, String name, String fatherName, String course) {
            this.id = id;
            this.name = name;
            this.fatherName = fatherName;
            this.course = course;
        }
    }

    // Method to add book information
    public static void BooksInfo() {
        // Icons for save and close buttons
        ImageIcon saveicon = new ImageIcon("save.png");
        ImageIcon closeIcon = new ImageIcon("cross.png");

        // Create a JFrame for the book information form
        JFrame frame4 = new JFrame();
        frame4.setSize(700, 450);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setLayout(null);

        // Create a JPanel with the background image for the form
        JPanel panel4 = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bgform.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel4.setLayout(null); // Use absolute layout
        panel4.setBounds(0, 0, 700, 450);

        // Labels and text areas for book ID, name, and publisher
        JLabel id = new JLabel("Book ID");
        id.setFont(new Font("Times New Roman", Font.BOLD, 20));
        id.setBounds(180, 80, 100, 30);

        JTextArea idarea = new JTextArea();
        idarea.setFont(new Font("Times New Roman", Font.BOLD, 20));
        idarea.setBounds(350, 80, 200, 30);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Times New Roman", Font.BOLD, 20));
        name.setBounds(180, 120, 100, 30);

        JTextArea namearea = new JTextArea();
        namearea.setFont(new Font("Times New Roman", Font.BOLD, 20));
        namearea.setBounds(350, 120, 200, 30);

        JLabel fname = new JLabel("Publisher");
        fname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        fname.setBounds(180, 160, 120, 30);

        JTextArea fnamearea = new JTextArea();
        fnamearea.setFont(new Font("Times New Roman", Font.BOLD, 20));
        fnamearea.setBounds(350, 160, 200, 30);

        // Save button to save book information
        JButton save = new JButton("Save");
        save.setFont(new Font("Times New Roman", Font.BOLD, 20));
        save.setBounds(200, 300, 120, 40);
        save.setIcon(saveicon);

        // Action listener for save button
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get entered book information
                String Id = idarea.getText();
                String name = namearea.getText();
                String publisher = fnamearea.getText();

                // Check if all fields are filled
                if (Id.isEmpty() || name.isEmpty() || publisher.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields");
                    return;
                }

                // Check if student ID already exists
                for (Book book : booklist) {
                    if (book.id.equals(Id)) {
                        JOptionPane.showMessageDialog(null, "Book ID already exists. Please enter a unique ID.");
                        return;
                    }
                }

                // Create a new Book object
                Book newbook = new Book(Id, name, publisher);

                // Add the book to the ArrayList
                booklist.add(newbook);
                JOptionPane.showMessageDialog(null, "Book Added Successfully");

                // Clear input fields after saving
                idarea.setText("");
                namearea.setText("");
                fnamearea.setText("");
            }
        });

        // Close button to close the form
        JButton close = new JButton("Close");
        close.setFont(new Font("Times New Roman", Font.BOLD, 20));
        close.setBounds(400, 300, 120, 40);
        close.setIcon(closeIcon);

        // Action listener for close button
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == close) {
                    frame4.dispose(); // Close the book information form
                }
            }
        });

        // Add components to the panel
        panel4.add(id);
        panel4.add(idarea);
        panel4.add(name);
        panel4.add(namearea);
        panel4.add(fname);
        panel4.add(fnamearea);
        panel4.add(save);
        panel4.add(close);

        // Add the panel to the frame and display it
        frame4.add(panel4);
        frame4.setBounds(300, 200, 700, 450);
        frame4.setVisible(true);
    }

    // Book class to store book information
    static class Book {
        String id;
        String name;
        String publisher;

        Book(String id, String name, String publisher) {
            this.id = id;
            this.name = name;
            this.publisher = publisher;
        }
    }

    public static void IssueBook() {
        // Icons for issue and close buttons
        ImageIcon saveicon = new ImageIcon("issue2.png");
        ImageIcon closeIcon = new ImageIcon("cross.png");

        // Create a JFrame for the issue book form
        JFrame frame5 = new JFrame();
        frame5.setSize(700, 450);
        frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame5.setLayout(null);

        // Create a JPanel with the background image for the form
        JPanel panel5 = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bgform.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel5.setLayout(null); // Use absolute layout
        panel5.setBounds(0, 0, 700, 450);

        // Labels and text areas for student ID, book ID, issue date, and return date
        JLabel id = new JLabel("Student ID");
        id.setFont(new Font("Times New Roman", Font.BOLD, 20));
        id.setBounds(180, 80, 100, 30);

        JTextArea idarea = new JTextArea();
        idarea.setFont(new Font("Times New Roman", Font.BOLD, 20));
        idarea.setBounds(350, 80, 200, 30);

        JLabel name = new JLabel("Book ID");
        name.setFont(new Font("Times New Roman", Font.BOLD, 20));
        name.setBounds(180, 120, 100, 30);

        JTextArea namearea = new JTextArea();
        namearea.setFont(new Font("Times New Roman", Font.BOLD, 20));
        namearea.setBounds(350, 120, 200, 30);

        JLabel fname = new JLabel("Issue Date(dd-mm)");
        fname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        fname.setBounds(180, 160, 120, 30);

        JTextArea fnamearea = new JTextArea();
        fnamearea.setFont(new Font("Times New Roman", Font.BOLD, 20));
        fnamearea.setBounds(350, 160, 200, 30);

        JLabel textcourse = new JLabel("Return Date(dd-mm)");
        textcourse.setFont(new Font("Times New Roman", Font.BOLD, 20));
        textcourse.setBounds(180, 200, 120, 30);

        JTextArea course = new JTextArea();
        course.setFont(new Font("Times New Roman", Font.BOLD, 20));
        course.setBounds(350, 200, 200, 30);

        // Issue button to issue the book
        JButton save = new JButton("Issue");
        save.setFont(new Font("Times New Roman", Font.BOLD, 20));
        save.setBounds(200, 300, 120, 40);
        save.setIcon(saveicon);

        // Action listener for issue button
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get entered issue information
                String studentId = idarea.getText();
                String bookId = namearea.getText();
                String issueDate = fnamearea.getText();
                String returnDate = course.getText();

                // Check if all fields are filled
                if (studentId.isEmpty() || bookId.isEmpty() || issueDate.isEmpty() || returnDate.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields");
                    return;
                }

                // Check if student exists
                boolean studentExists = false;
                for (Student student : studentList) {
                    if (student.id.equals(studentId)) {
                        studentExists = true;
                        break;
                    }
                }

                // Check if book exists
                boolean bookExists = false;
                for (Book book : booklist) {
                    if (book.id.equals(bookId)) {
                        bookExists = true;
                        break;
                    }
                }

                // If both student and book exist, issue the book
                if (studentExists && bookExists) {
                    IssueBookClass bookissued = new IssueBookClass(bookId, studentId, issueDate, returnDate);
                    issueBooks.add(bookissued);

                    JOptionPane.showMessageDialog(null, "Book Issued Successfully");

                    // Clear input fields after issuing
                    idarea.setText("");
                    namearea.setText("");
                    fnamearea.setText("");
                    course.setText("");
                } else {
                    // Show error if student or book ID is incorrect
                    JOptionPane.showMessageDialog(null, "Incorrect student or book ID", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Close button to close the form
        JButton close = new JButton("Close");
        close.setFont(new Font("Times New Roman", Font.BOLD, 20));
        close.setBounds(400, 300, 120, 40);
        close.setIcon(closeIcon);

        // Action listener for close button
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == close) {
                    frame5.dispose(); // Close the issue book form
                }
            }
        });

        // Add components to the panel
        panel5.add(id);
        panel5.add(idarea);
        panel5.add(name);
        panel5.add(namearea);
        panel5.add(fname);
        panel5.add(fnamearea);
        panel5.add(textcourse);
        panel5.add(course);
        panel5.add(save);
        panel5.add(close);

        // Add the panel to the frame and display it
        frame5.add(panel5);
        frame5.setBounds(300, 200, 700, 450);
        frame5.setVisible(true);
    }

    // IssueBookClass to store issued book information
    static class IssueBookClass {
        String bookID;
        String studentID;
        String dateIssue;
        String dateReturn;

        public IssueBookClass(String bookID, String studentID, String dateIssue, String dateReturn) {
            this.bookID = bookID;
            this.studentID = studentID;
            this.dateIssue = dateIssue;
            this.dateReturn = dateReturn;
        }
    }

    // This method displays statistics related to issued books
    public static void Statics() {

        // Creating ImageIcon for the close button
        ImageIcon closeIcon = new ImageIcon("cross.png");

        // Creating a new JFrame for displaying statistics
        JFrame frame7 = new JFrame();
        frame7.setSize(700, 450);
        frame7.setLayout(null);

        // Creating a JPanel to hold components with a custom background
        JPanel panel7 = new JPanel() {
            // Custom painting to set background image
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bgform.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        // Using absolute layout
        panel7.setLayout(null);
        panel7.setBounds(0, 0, 700, 450);

        // Defining column names for the JTable
        String[] columnNames = { "Student ID", "Student Name", "Book ID", "Book Name", "Issue Date", "Return Date" };
        // Creating data object for the JTable
        Object[][] data = new Object[issueBooks.size()][6];

        // Populating data for the JTable
        for (int i = 0; i < issueBooks.size(); i++) {
            IssueBookClass book = issueBooks.get(i);
            Student student = null;
            Book bookObj = null;
            // Finding corresponding student for the issued book
            for (Student s : studentList) {
                if (s.id.equals(book.studentID)) {
                    student = s;
                    break;
                }
            }
            // Finding corresponding book for the issued book
            for (Book b : booklist) {
                if (b.id.equals(book.bookID)) {
                    bookObj = b;
                    break;
                }
            }
            // Setting data for each row in the JTable
            data[i][0] = book.studentID;
            data[i][1] = student.name;
            data[i][2] = book.bookID;
            data[i][3] = bookObj.name;
            data[i][4] = book.dateIssue;
            data[i][5] = book.dateReturn;
        }

        // Creating JTable to display data
        JTable table = new JTable(data, columnNames);
        table.setBounds(10, 10, 680, 350);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 680, 350);

        // Creating close button
        JButton close = new JButton("Close");
        close.setFont(new Font("Times New Roman", Font.BOLD, 20));
        close.setBounds(400, 300, 120, 40);
        close.setIcon(closeIcon);
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == close) {
                    frame7.dispose();
                }
            }
        });

        // Adding components to panel and frame
        panel7.add(scrollPane);
        panel7.add(close);
        frame7.add(panel7);
        frame7.setVisible(true);
    }

    // This method handles the returning of books
    public static void ReturnBook() {
        // Creating ImageIcons for buttons
        ImageIcon saveicon = new ImageIcon("returnbook.png");
        ImageIcon closeIcon = new ImageIcon("cross.png");
        ImageIcon searchicon = new ImageIcon("search.png");

        // Creating JFrame for returning books
        JFrame frame6 = new JFrame();
        frame6.setSize(700, 450);
        frame6.setLayout(null);

        // Creating JPanel with custom background
        JPanel panel6 = new JPanel() {
            // Custom painting for setting background image
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bgform.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        // Using absolute layout
        panel6.setLayout(null);
        panel6.setBounds(0, 0, 700, 450);

        // Creating and positioning labels and text areas for user input
        JLabel id = new JLabel("Student ID");
        id.setFont(new Font("Times New Roman", Font.BOLD, 20));
        id.setBounds(180, 80, 100, 30);
        JTextArea idarea = new JTextArea();
        idarea.setFont(new Font("Times New Roman", Font.BOLD, 20));
        idarea.setBounds(350, 80, 200, 30);

        JLabel name = new JLabel("Book ID");
        name.setFont(new Font("Times New Roman", Font.BOLD, 20));
        name.setBounds(180, 120, 100, 30);
        JButton search = new JButton("");
        search.setFont(new Font("Times New Roman", Font.BOLD, 20));
        search.setBounds(560, 120, 100, 30);
        search.setIcon(searchicon);
        JTextArea namearea = new JTextArea();
        namearea.setFont(new Font("Times New Roman", Font.BOLD, 20));
        namearea.setBounds(350, 120, 200, 30);

        JLabel fname = new JLabel("Issue Date(dd-mm)");
        fname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        fname.setBounds(180, 160, 120, 30);
        JTextArea fnamearea = new JTextArea();
        fnamearea.setFont(new Font("Times New Roman", Font.BOLD, 20));
        fnamearea.setBounds(350, 160, 200, 30);

        JLabel textcourse = new JLabel("Due Date(dd-mm)");
        textcourse.setFont(new Font("Times New Roman", Font.BOLD, 20));
        textcourse.setBounds(180, 200, 120, 30);
        JTextArea course = new JTextArea();
        course.setFont(new Font("Times New Roman", Font.BOLD, 20));
        course.setBounds(350, 200, 200, 30);

        JLabel today = new JLabel("Today Date(dd-mm)");
        today.setFont(new Font("Times New Roman", Font.BOLD, 20));
        today.setBounds(180, 240, 120, 30);
        JTextArea todayarea = new JTextArea();
        todayarea.setFont(new Font("Times New Roman", Font.BOLD, 20));
        todayarea.setBounds(350, 240, 200, 30);

        // Creating buttons for returning and closing
        JButton save = new JButton("Return");
        save.setFont(new Font("Times New Roman", Font.BOLD, 20));
        save.setBounds(200, 300, 120, 40);
        save.setIcon(saveicon);
        JButton close = new JButton("Close");
        close.setFont(new Font("Times New Roman", Font.BOLD, 20));
        close.setBounds(400, 300, 120, 40);
        close.setIcon(closeIcon);
        // ActionListener for closing the frame
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == close) {
                    frame6.dispose();
                }
            }
        });

        // ActionListener for handling book return process
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Getting input data
                String studentId = idarea.getText();
                String bookId = namearea.getText();
                String issuedate = fnamearea.getText();
                String returndate = course.getText();
                String todaydate = todayarea.getText();

                // Validating input data
                if (studentId.isEmpty() || bookId.isEmpty() || issuedate.isEmpty() || returndate.isEmpty()
                        || todaydate.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields");
                    return;
                }

                // Converting String dates to integers for comparison
                int a = Integer.valueOf(returndate);
                int b = Integer.valueOf(todaydate);

                // Checking if book is returned late
                if (b > a) {
                    JOptionPane.showMessageDialog(null, "You are Returning Book Late, So you are Fined 200Rs");
                }

                // Checking if the book is issued and removing it from the list
                boolean bookIssued = false;
                IssueBookClass issuedBook = null;
                for (IssueBookClass book : issueBooks) {
                    if (book.bookID.equals(bookId) && book.studentID.equals(studentId)) {
                        bookIssued = true;
                        issuedBook = book;
                        break;
                    }
                }

                if (bookIssued) {
                    issueBooks.remove(issuedBook);
                    JOptionPane.showMessageDialog(null, "Book returned successfully");
                    // Clearing text fields after successful return
                    idarea.setText("");
                    namearea.setText("");
                    fnamearea.setText("");
                    course.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "No book was borrowed or Incorrect student or Book ID");
                }
            }
        });

        // Adding components to panel and frame
        panel6.add(id);
        panel6.add(idarea);
        panel6.add(name);
        panel6.add(search);
        panel6.add(namearea);
        panel6.add(fname);
        panel6.add(fnamearea);
        panel6.add(textcourse);
        panel6.add(course);
        panel6.add(today);
        panel6.add(todayarea);
        panel6.add(save);
        panel6.add(close);
        frame6.add(panel6);
        frame6.setBounds(300, 200, 700, 450);
        frame6.setVisible(true);
    }

    // This method Shows Num of Students and Books in Tabular Form
    public static void Total() {
        ImageIcon closeIcon = new ImageIcon("cross.png");

        JFrame frame8 = new JFrame();
        frame8.setSize(700, 450);
        frame8.setLayout(null);

        JPanel panel8 = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bgform.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel8.setLayout(null); // Use absolute layout
        panel8.setBounds(0, 0, 700, 450);

        JLabel studs = new JLabel("Students Details");
        studs.setFont(new Font("Times New Roman", Font.BOLD, 20));
        studs.setBounds(300, 20, 150, 40);

        String[] columnNames = { "Student ID", "Student Name", "Father Name", "Course" };
        Object[][] data = new Object[studentList.size()][4];

        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            data[i][0] = student.id;
            data[i][1] = student.name;
            data[i][2] = student.fatherName;
            data[i][3] = student.course;
        }

        JTable studentTable = new JTable(data, columnNames);
        studentTable.setBounds(10, 50, 680, 150);
        JScrollPane studentScrollPane = new JScrollPane(studentTable);
        studentScrollPane.setBounds(10, 50, 680, 150);

        JLabel books = new JLabel("Books Details");
        books.setFont(new Font("Times New Roman", Font.BOLD, 20));
        books.setBounds(300, 220, 120, 40);

        String[] bookColumnNames = { "Book ID", "Book Name", "Publisher" };
        Object[][] bookData = new Object[booklist.size()][3];

        for (int i = 0; i < booklist.size(); i++) {
            Book book = booklist.get(i);
            bookData[i][0] = book.id;
            bookData[i][1] = book.name;
            bookData[i][2] = book.publisher;
        }

        JTable bookTable = new JTable(bookData, bookColumnNames);
        bookTable.setBounds(10, 250, 680, 150);
        JScrollPane bookScrollPane = new JScrollPane(bookTable);
        bookScrollPane.setBounds(10, 250, 680, 150);

        JButton close = new JButton("Close");
        close.setFont(new Font("Times New Roman", Font.BOLD, 20));
        close.setBounds(550, 400, 120, 40);
        close.setIcon(closeIcon);
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == close) {
                    frame8.dispose();
                }
            }
        });

        panel8.add(studs);
        panel8.add(studentScrollPane);
        panel8.add(books);
        panel8.add(bookScrollPane);
        panel8.add(close);
        frame8.add(panel8);
        frame8.setVisible(true);
    }
}
