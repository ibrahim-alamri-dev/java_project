import java.util.ArrayList; // تحمل مكتبة تعطينا لسته نقدر نحط فيها بيانات
import java.util.List; // نفس الي فوق بس نوع ثاني
import java.util.Scanner; // هذه نحملها عشان نقدر نقرا البيانات المدخلة من اليوزر

public class Main {
    // ذا الجزء يعرف وش الكورس ووش مكوناته
    public static class Course {
        private String title; // اسم الكورس
        private String instructor; // اسم المدرس
        private String area; // موقع الكورس مثال: الرياض, خشم العان. الي هو...

        // هذا يسوي كورس بالعنوان حقه اسم المدرس والموقع
        public Course(String title, String instructor, String area) {
            this.title = title;
            this.instructor = instructor;
            this.area = area;
        }

        // ميثود نقرا ونحدد فيها اسماء اشياء مثل اسم الكورس والمدرس والموقع
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getInstructor() {
            return instructor;
        }

        public void setInstructor(String instructor) {
            this.instructor = instructor;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        // هذا يستعرض تفاصيل الكورس بشكل مرتب.
        @Override
        public String toString() {
            return "Course: " + title + ", Instructor: " + instructor + ", Area: " + area;
        }
    }

    // ذا الجزء يهندل لستة الكورسات
    public static class Supervisor {
        private List<Course> courses; // List to hold multiple courses

        // هنا دخلت معلومات كورس من راسي بشكل مبدئي
        public Supervisor() {
            courses = new ArrayList<>();
            courses.add(new Course("Java Basics", "ibrahim a", "Computer Science"));
            courses.add(new Course("Data Structures", "amjad b", "Computer Science"));
            courses.add(new Course("Introduction to Psychology", "Mohammed c", "Psychology"));
            courses.add(new Course("History of Art", "ahmed h", "Art"));
        }

        // هذا يضيف كورس جديد للسته حقت الكورسات
        public void addCourse(String title, String instructor, String area) {
            Course newCourse = new Course(title, instructor, area); // Creates the new course
            courses.add(newCourse); // Adds it to the list
            System.out.println("Course added successfully!");
        }

        // هذا يطلع لك كل الكورسات
        public void displayCourses() {
            for (Course course : courses) {
                System.out.println(course); // اطبع لي الكورسات لاهنت
            }
        }

        // هذا فلتر يعطي اليوزر خاصية البحث عن كورس حسب الموقع
        public void displayCoursesByArea(String area) {
            boolean found = false; // يشيك اذا لقى كورسات في الموقع المدخل من اليوزر
            for (Course course : courses) {
                if (course.getArea().equalsIgnoreCase(area)) {
                    System.out.println(course); // اطبع لي الكورسات الي في الموقع المدخل
                    found = true;
                }
            }
            if (!found) { // اذا ما لقى كورسات يعطي ذا الرسالة
                System.out.println("No courses found in this area.");
            }
        }

        // هذا فلتر يبحث عن كورس حسب عنوانه او اسم المدرس
        public void searchCourses(String keyword) {
            boolean found = false; // يشيك اذا لقى كورسات
            for (Course course : courses) {
                if (course.getTitle().equalsIgnoreCase(keyword) ||
                        course.getInstructor().equalsIgnoreCase(keyword)) {
                    System.out.println(course);
                    found = true;
                }
            }
            if (!found) { // اذا ما لقى كورسات يعطي ذا الرسالة
                System.out.println("No courses found with the given keyword.");
            }
        }

        // هذا يطلع لك كل الكورسات الي موجودة
        public void browseCourses() {
            displayCourses();
        }
    }

    // هذا البرنامج الي بيتفاعل معه اليوزر
    public static void main(String[] args) {
        Supervisor supervisor = new Supervisor(); // يضيف سوبرفايزر جديد
        Scanner scanner = new Scanner(System.in); // يجهز سكانر عشان يقرا من اليوزر

        while (true) { // خل البرنامج شغال لين اليورز يختار EXIT
            // يوري اليوزر الخيارات الي يقدر يسويها
            System.out.println("\nWelcome to the Courses Management System");
            System.out.println("1. Add a new course");
            System.out.println("2. Display all courses");
            System.out.println("3. Search for a course by title or instructor");
            System.out.println("4. Display courses by area");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt(); // يقرا خيار اليورز
            scanner.nextLine();

            // الحين نبدا نهندل الخيارات بناء على اختيار اليوزر من المنيو الي فوق
            switch (choice) {
                case 1:
                    // اذا اليوزر دخل رقم واحد معناها يبي يضيف كورس جديد حسب نعريفنا فوق للخيارات.
                    // فنطلب منه بعدها يدخل اسم الكورس واسم المدرس وموقع الكورس
                    System.out.print("Enter course title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter course instructor: ");
                    String instructor = scanner.nextLine();
                    System.out.print("Enter course area: ");
                    String area = scanner.nextLine();
                    supervisor.addCourse(title, instructor, area);
                    break;

                case 2:
                    // نفس الفكرة الي فوق
                    System.out.println("Displaying all courses:");
                    supervisor.displayCourses();
                    break;

                case 3:
                    // لا جديد
                    System.out.print("Enter course title or instructor to search: ");
                    String keyword = scanner.nextLine();
                    supervisor.searchCourses(keyword);
                    break;

                case 4:
                    // يب
                    System.out.print("Enter course area to display: ");
                    String searchArea = scanner.nextLine();
                    supervisor.displayCoursesByArea(searchArea);
                    break;

                case 5:
                    // طلعني من البرنامج باةك الله فيك
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close(); // قفل البرنامج
                    return; // نرجع ولا شي في النهاية عشان نتأكد اننا طلعنا من اللوب

                default:
                    // اذا استعبط اليوزر ودخل خيار مو موجود من الخيارات المتوفرة
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
