package services;

import dao.GroupsDao;
import entities.Group;

import java.util.List;

public class GroupsService {
    GroupsDao groupsDao = new GroupsDao();
    public Group findGroupById(int group_id){
        return groupsDao.findGroupById(group_id);
    }
    public Group findGroupByName(String group_name){
        return groupsDao.findGroupByName(group_name);
    }
    public List<Group> showAll(){
        return groupsDao.showAll();
    }
    public String updateGroupNameById(int group_id, String group_name){
        return groupsDao.updateGroupNameById(group_id, group_name);
    }
    public String updateGroupNameByName(String old_group_name, String new_group_name){
        return groupsDao.updateGroupNameByName(old_group_name, new_group_name);
    }
    public String deleteGroupById(int group_id){
        return groupsDao.deleteGroupById(group_id);
    }
    public String deleteGroupByName(String group_name){
        return groupsDao.deleteGroupByName(group_name);
    }
    public String createGroup(String group_name){
        return groupsDao.createGroup(group_name);
    }
}
