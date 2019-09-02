import java.util.Date;

@Table(name = "janus_merch_auth_res")
public class MerchantAuth  {

    @Column(name = "auth_id")
    private String authId;

    @Column(name = "parent_id")
    private String parentId;

    @Column(name = "res_id")
    private String resourceId;

    private String resourceName;

    private String resourceType;

    private String resourceAddress;

    private String btnAddress;

    @Column(name = "id", pk = true)
    private Integer id;

    /**
     创建时间
     */
    private Date createdDate;

    /**
     创建者
     */
    private String created;

    /**
     修改时间
     */
    private Date modifiedDate;

    /**
     修改者
     */
    private String modified;

    /**
     * 数据状态
     */
    private Integer dbStatus;

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceAddress() {
        return resourceAddress;
    }

    public void setResourceAddress(String resourceAddress) {
        this.resourceAddress = resourceAddress;
    }

    public String getBtnAddress() {
        return btnAddress;
    }

    public void setBtnAddress(String btnAddress) {
        this.btnAddress = btnAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Integer getDbStatus() {
        return dbStatus;
    }

    public void setDbStatus(Integer dbStatus) {
        this.dbStatus = dbStatus;
    }

    @Override
    public String toString() {
        return "MerchantAuth{" +
                "authId='" + authId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", resourceName='" + resourceName + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", resourceAddress='" + resourceAddress + '\'' +
                ", btnAddress='" + btnAddress + '\'' +
                ", id=" + id +
                ", createdDate=" + createdDate +
                ", created='" + created + '\'' +
                ", modifiedDate=" + modifiedDate +
                ", modified='" + modified + '\'' +
                ", dbStatus=" + dbStatus +
                '}';
    }
}
