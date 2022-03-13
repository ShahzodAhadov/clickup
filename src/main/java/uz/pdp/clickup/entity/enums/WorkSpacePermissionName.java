package uz.pdp.clickup.entity.enums;

import uz.pdp.clickup.entity.WorkSpace;
import uz.pdp.clickup.entity.WorkSpaceRole;

import java.util.Arrays;
import java.util.List;

public enum WorkSpacePermissionName {
    CAN_ADD_OR_REMOVE_MEMBER("Add/Remove Members",
            "Gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkSpaceRoleName.ROLE_ADMIN, WorkSpaceRoleName.ROLE_OWNER)
    ),
    CAN_MANAGE_STATUS("Edit status", "Gives permission...",
            Arrays.asList(WorkSpaceRoleName.ROLE_ADMIN, WorkSpaceRoleName.ROLE_OWNER)
    );

    public String name;
    public String description;
    public List<WorkSpaceRoleName> workSpaceRoleNames;

    WorkSpacePermissionName(String name, String description, List<WorkSpaceRoleName> workSpaceRoleNames) {
        this.name = name;
        this.description = description;
        this.workSpaceRoleNames = workSpaceRoleNames;
    }
}
