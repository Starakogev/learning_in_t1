package collections.hashMap;

public class CustomKey {
    private int number;
    private String content;
    private String text;

    public CustomKey() {
    }

    public CustomKey(int number, String content, String text) {
        this.number = number;
        this.content = content;
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public String getContent() {
        return content;
    }

    public String getText() {
        return text;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        CustomKey key = (CustomKey) o;
        return number == key.number
                && (content == key.content || (content != null && content.equals(key.getContent())))
                && (text == key.text || (text != null && text.equals(key.getText())));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        result = prime * result + number;
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        return result;
    }
}
