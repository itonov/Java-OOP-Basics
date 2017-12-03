package mankind;

public class Worker extends Human {
    private double weekSalary;
    private double workHours;

    public Worker(String firstName, String lastName, double salary, double workHours) {
        super(firstName, lastName);
        setWeekSalary(salary);
        setWorkHours(workHours);
    }

    private void setWorkHours(double workHours) {
        if (workHours < 1 || workHours > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHours = workHours;
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary < 11) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private double salaryPerHour() {
        return this.weekSalary / (this.workHours * 7);
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() < 4) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("First Name: ").append(super.firstName)
                .append(System.lineSeparator())
                .append("Last Name: ").append(super.lastName)
                .append(System.lineSeparator())
                .append("Week Salary: ").append(String.format("%.2f", this.weekSalary))
                .append(System.lineSeparator())
                .append("Hours per day: ").append(String.format("%.2f", this.workHours))
                .append(System.lineSeparator())
                .append("Salary per hour: ").append(String.format("%.2f", salaryPerHour()));
        return sb.toString();
    }
}
