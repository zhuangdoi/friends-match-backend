package com.yupi.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.usercenter.model.domain.Team;
import com.yupi.usercenter.model.domain.User;
import com.yupi.usercenter.model.dto.TeamQuery;
import com.yupi.usercenter.model.request.TeamJoinRequest;
import com.yupi.usercenter.model.request.TeamQuitRequest;
import com.yupi.usercenter.model.request.TeamUpdateRequest;
import com.yupi.usercenter.model.vo.TeamUserVO;

import java.util.List;

/**
* @author Administrator
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2023-08-08 17:20:56
*/
public interface TeamService extends IService<Team> {

     /**
      * 创建队伍
      * @param team
      * @param loginUser
      * @return 队伍Id
      */
     long addTeam(Team team, User loginUser);

    /**
     * 搜索队伍
     * @param teamQuery
     * @param isAdmin
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery,boolean isAdmin);

    /**
     * 更新队伍
     * @param teamUpdateRequest
     * @param loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest,User loginUser);

    /**
     * 加入队伍
     * @param teamJoinRequest
     * @param logininUser
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest,User logininUser);


    /**
     * 退出队伍
     * @param teamQuitRequest
     * @param logininUser
     * @return
     */
    boolean quitTeam(TeamQuitRequest teamQuitRequest, User logininUser);

    /**
     * 解散队伍
     * @param teamId
     * @param logininUser
     * @return
     */
    boolean deleteTeam(Long teamId, User logininUser);
}
