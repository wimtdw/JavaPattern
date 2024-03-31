package lab6;
class User {
    private String firstName;
    private String lastName;
    private int age;
    private String email;

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.email = builder.email;
    }

    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private int age;
        private String email;

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public static void main(String[] args) {
        User user = new User.UserBuilder("Ivan", "Ivanov")
                .age(30)
                .email("ivan@example.com")
                .build();

        System.out.println("User: " + user.getFirstName() + " " + user.getLastName());
        System.out.println("Age: " + user.getAge());
        System.out.println("Email: " + user.getEmail());
    }
}
