package ro.jademy.librarymgmt;

public class Review {
    private String text;
    private String clientName;

    public Review(String text, String clientName) {
        this.text = text;
        this.clientName = clientName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "Client name : " + this.clientName + "\n" + "Review : " +this.text+"\n\n";
    }

    public void printReviews() {
        System.out.println(this);
    }

}
