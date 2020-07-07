package o2oboot.entity;

public class Access {
    private Long accessId;
    private String accessName;
    private String url;
    private int accessNumber;

    public Access() {
    }

    public Access(Long accessId, String accessName, String url) {
        this.accessId = accessId;
        this.accessName = accessName;
        this.url = url;

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAccessNumber() {
        return accessNumber;
    }

    public void setAccessNumber(int accessNumber) {
        this.accessNumber = accessNumber;
    }

    public Long getAccessId() {
        return accessId;
    }

    public void setAccessId(Long accessId) {
        this.accessId = accessId;
    }

    public String getAccessName() {
        return accessName;
    }

    public void setAccessName(String accessName) {
        this.accessName = accessName;
    }
}
