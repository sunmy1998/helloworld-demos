package com.swy;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.query.MPJQueryWrapper;
import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.toolkit.MPJWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.swy.dto.UserDTO;
import com.swy.entity.AddressDO;
import com.swy.entity.AreaDO;
import com.swy.entity.UserDO;
import com.swy.mapper.UserMapper;
import com.swy.service.AreaService;
import com.swy.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class JoinTest {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserService userService;

	@Autowired
	private AreaService areaService;

	/**
	 * 一对多
	 */
	@Test
	void testJoin() {

		MPJLambdaWrapper<UserDO> wrapper = new MPJLambdaWrapper<UserDO>()
				.selectAll(UserDO.class)
				.selectCollection(AddressDO.class, UserDTO::getAddressList)
				.leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
				.orderByDesc(UserDO::getId);

		List<UserDTO> list = userMapper.selectJoinList(UserDTO.class, wrapper);
		list.forEach(System.out::println);

	}

	@Test
	void testJoin1() {
		MPJLambdaWrapper<UserDO> wrapper = new MPJLambdaWrapper<UserDO>()
				.selectAll(UserDO.class)
				.selectCollection(AddressDO.class, UserDTO::getAddressList)
				.leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
				.orderByDesc(UserDO::getId);

		List<UserDTO> list = userService.selectJoinList(UserDTO.class, wrapper);
		list.forEach(System.out::println);
	}

	@Test
	void testJoin2() {
		MPJLambdaWrapper<AreaDO> wrapper = new MPJLambdaWrapper<>(AreaDO.class)
				.selectAll()
				.orderByDesc(AreaDO::getId);

		List<AreaDO> list = areaService.selectJoinList(AreaDO.class, wrapper);
		list.forEach(System.out::println);
	}

	/**
	 * 简单的分页关联查询 lambda
	 */
	@Test
	void test1() {
		Page<UserDTO> page = userMapper.selectJoinPage(new Page<>(1, 10), UserDTO.class,
				new MPJLambdaWrapper<UserDO>()
						.selectAll(UserDO.class)
						.select(AddressDO::getAddress)
						.select(AreaDO::getProvince)
						.leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
						.leftJoin(AreaDO.class, AreaDO::getId, AddressDO::getAreaId)
		);
		page.getRecords().forEach(System.out::println);
	}

	/**
	 * 简单的关联查询 String
	 */
	@Test
	void test2() {
		MPJQueryWrapper<UserDO> wrapper = JoinWrappers.query(UserDO.class)
				.selectAll(UserDO.class)
				.selectAll(AddressDO.class, "addr")
				.selectAll(AreaDO.class, "a")
				.selectIgnore("addr.id", "a.id", "t.del", "addr.del")
				.leftJoin("user_address addr on t.id = addr.user_id")
				.leftJoin("area a on a.id = addr.area_id")
				.eq("t.id", 1);

		List<UserDO> list = userMapper.selectList(wrapper);
		list.forEach(System.out::println);
	}

	/**
	 * 简单的分页关联查询 lambda
	 * ON语句多条件
	 */
	@Test
	void test3() {
		IPage<UserDTO> page = userMapper.selectJoinPage(new Page<>(1, 10), UserDTO.class,
				JoinWrappers.lambda(UserDO.class)
						.selectAll(UserDO.class)
						.select(AddressDO::getAddress)
						.leftJoin(AddressDO.class, on -> on
								.eq(UserDO::getId, AddressDO::getUserId)
								.eq(UserDO::getId, AddressDO::getUserId))
						.eq(UserDO::getId, 1)
						.and(i -> i.eq(UserDO::getHeadImg, "er")
								.or()
								.eq(AddressDO::getUserId, 1))
						.eq(UserDO::getId, 1));
		page.getRecords().forEach(System.out::println);
	}

	/**
	 * 简单的函数使用
	 */
	@Test
	void test4() {
		UserDTO one = userMapper.selectJoinOne(UserDTO.class, MPJWrappers.<UserDO>lambdaJoin()
				.selectSum(UserDO::getId)
				.selectMax(UserDO::getId, UserDTO::getHeadImg)
				.leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
				.eq(UserDO::getId, 1));
		System.out.println(one);
	}

	/**
	 * 忽略个别查询字段
	 */
	@Test
	void test6() {
		IPage<UserDTO> page = userMapper.selectJoinPage(new Page<>(1, 10), UserDTO.class,
				MPJWrappers.<UserDO>lambdaJoin()
						.selectAll(UserDO.class)
						.selectFilter(AddressDO.class, p -> false)
						.select(AddressDO::getAddress)
						.leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
						.eq(UserDO::getId, 1));
		page.getRecords().forEach(System.out::println);
	}

	/**
	 * 关联查询返回map
	 */
	@Test
	void test7() {
		List<Map<String, Object>> list = userMapper.selectJoinMaps(MPJWrappers.<UserDO>lambdaJoin()
				.selectAll(UserDO.class)
				.select(AddressDO::getAddress)
				.leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
				.eq(UserDO::getId, 1));
		list.forEach(System.out::println);
	}

}
