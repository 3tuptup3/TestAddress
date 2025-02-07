package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Address;

import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class AddressRepositoryImpl implements AddressRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	/*--- 検索 ---*/
	@Override
	public List<Address> selectByNameWildcard(String lastName) {
		
		String sql =
				" SELECT                " +
				"   id,                 " +
				"   last_name,          " +
				"   first_name,         " +
				"   middle_name,        " +
				"   maiden_name,        " +
				"   common_name,        " +
				"   last_name_kana,     " +
				"   first_name_kana,    " +
				"   middle_name_kana,   " +
				"   maiden_name_kana,   " +
				"   common_name_kana,   " +
				"   category1,          " +
				"   phone_number1,      " +
				"   phone_number2,      " +
				"   e_mail1,            " +
				"   e_mail2,            " +
				"   post_code,          " +
				"   address,            " +
				"   team,               " +
				"   birth_year,         " +
				"   birth_month,        " +
				"   birth_day,          " +
				"   remarks,            " +
				"   insert_datetime,    " +
				"   insert_user,        " +
				"   update_datetime,    " +
				"   update_user         " +
				" FROM                  " +
				"   t_address03         " +
				" WHERE                 " +
				"   last_name LIKE ?    ";
		
		// プレースホルダの値
		String p = "%" + lastName + "%";
		
		// SQLで検索
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, p);
		
		// 値の取得→結果の格納
		// Map型のListをAddress型のListに変換
		List<Address> result = new ArrayList<Address>();
		for (Map<String, Object> one : list) {
			Address address = new Address();
			address.setAddressId((int)one.get("id"));
			address.setLastName((String)one.get("last_name"));
			address.setFirstName((String)one.get("first_name"));
			address.setCommonName((String)one.get("common_name"));
			address.setTeam((String)one.get("team"));
			result.add(address);
		}
		
		// 全件分
		return result;
	}


	/*--- 登録 ---*/
	@Override
	public void add(Address address) {
		
		String sql =
				" INSERT INTO t_address03 " +
				" (last_name, first_name, common_name, team, insert_datetime, insert_user) " +
				" Values (?, ?, ?, ?, CURRENT_TIMESTAMP(), 'test_user') ";
		
		jdbcTemplate.update(sql, 
				address.getLastName(),
				address.getFirstName(),
				address.getCommonName(),
				address.getTeam());
		
	}

	/*--- 更新 ---*/
	@Override
	public void update(Address address) {	
		
		String sql =
				" UPDATE									" +
				" 	t_address03								" +
				" SET										" +
				" 	last_name = ?,							" +
				" 	first_name = ?,							" +
				" 	common_name = ?,						" +
				" 	team = ?,								" +
				" 	update_datetime = CURRENT_TIMESTAMP(),	" +
				" 	update_user = 'test_user'				" +
				" WHERE										" +
				" 	id = ?									";
		
		jdbcTemplate.update(sql, 
				 address.getLastName(),
				 address.getFirstName(),
				 address.getCommonName(),
				 address.getTeam(),
				 address.getAddressId());

		
	}

	/*--- 削除 ---*/
	@Override
	public void delete(Address address) {
		
		String sql =
				" DELETE			" +
				" FROM				" +
				" 	t_address03		" +
				" WHERE				" +
				" 	id = ?			";
					
		jdbcTemplate.update(sql, address.getAddressId());
		
	}

}
