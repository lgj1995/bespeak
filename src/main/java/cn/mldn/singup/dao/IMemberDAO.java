package cn.mldn.singup.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.singup.vo.Member;

public interface IMemberDAO {
	/**
	 * 实现用户基本数据的更新处理
	 * @param vo
	 * @return
	 */
	public boolean doUpdate(Member vo) ;
	
	/**
	 * 取得一个用户对应的所有的角色编号
	 * @param mid
	 * @return
	 */ 
	public Set<Integer> findAllRoleByMember(String mid) ;
	/**
	 * 在更新前先删除掉所有member_role与此用户有关系的数据信息
	 * @param mid
	 * @return
	 */
	public boolean doRemoveMemberAndRole(String mid) ;
	
	/**
	 * 实现member_role关系表的数据保存
	 * @param params 包含有两类数据：<br>
	 * 1、key = mid、value = 用户id；<br>
	 * 2、key = rid、value = 角色id；<br>
	 * @return
	 */
	public boolean doCreateMemberAndRole(Map<String,Object> params) ;
	
	/**
	 * 实现用户的追加处理，所有的追加用户的锁定状态都应该是活跃
	 * @param vo
	 * @return
	 */
	public boolean doCreate(Member vo) ;
	/**
	 * 进行用户锁定状态的更新操作，锁定状态：<br>
	 * 1、locked = 0，表示该用户属于活跃用户，不锁定；<br>
	 * 2、locked = 1，表示该用户被锁定， 无法登录；<br>
	 * @param params 包含有用户更新所需要的以下参数：<br>
	 * 1、key = mid、value = 要更新用户的mid；<br>
	 * 2、key = locked、value = 表示锁定的状态；<br>
	 * @return
	 */
	public boolean doUpdateLocked(Map<String,Object> params) ;
	/**
	 * 实现用户密码的变更，但是不会变更超级管理员的密码
	 * @param params 要进行变更的数据，包含有以下内容：<br>
	 * key = mid、value = 要修改的用户编号；<br>
	 * key = password、value = 要更改的新密码（已经加密过的）；<br>
	 * @return
	 */
	public boolean doUpdatePasswordByAdmin(Map<String,Object> params) ;   
	/**
	 * 查询全部的用户数据 
	 * @return
	 */
	public List<Member> findAll() ;
	/** 
	 * 根据id实现member数据的查询过程
	 * @param mid 要查询的mid的数据
	 * @return
	 */
	public Member findById(String mid) ;
	/**
	 * 进行用户密码的修改处理
	 * @param params 此时要传递两个参数：<br>
	 * 参数一：key = mid、value = 要修改的用户编号；<br>
	 * 参数二：key = newPassword、value = 加密后的新密码；<br>
	 * @return 修改成功返回true，否则返回false
	 */ 
	public boolean doUpdatePassword(Map<String,Object> params) ;
}
