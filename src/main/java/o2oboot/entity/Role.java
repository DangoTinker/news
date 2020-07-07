package o2oboot.entity;

import o2oboot.entity.Access;

import java.util.List;

public class Role {
    private Long roleId;
    private String roleName;
    private List<Access> accesses;
    public Role() {

    }
    public Role(Long roleId, String roleName, List<Access> accesses) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.accesses = accesses;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Access> getAccesses() {
        return accesses;
    }

    public void setAccesses(List<Access> accesses) {
        this.accesses = accesses;
    }
}
