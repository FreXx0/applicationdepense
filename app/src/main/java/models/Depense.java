package models;

public class Depense {
    private int id;
    private int userId;
    private double amount;
    private String description;

    public Depense() {}

    public Depense(int userId, double amount, String description) {
        this.userId = userId;
        this.amount = amount;
        this.description = description;
    }

    // Getters et setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
