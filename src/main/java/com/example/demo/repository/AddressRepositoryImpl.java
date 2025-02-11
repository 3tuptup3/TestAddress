package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Address;
import com.example.demo.form.AddressSearchForm;

import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class AddressRepositoryImpl implements AddressRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	/*--- 検索 ---*/
	@Override
	public List<Address> selectByNameWildcard(AddressSearchForm search) {
		
		String sql =
				" SELECT                			" +
				"   id,                 			" +
				"   last_name,          			" +
				"   middle_name,        			" +
				"   first_name,         			" +
				"   maiden_name,        			" +
				"   common_name,        			" +
				"   last_name_kana,     			" +
				"   middle_name_kana,   			" +
				"   first_name_kana,    			" +
				"   maiden_name_kana,   			" +
				"   common_name_kana,   			" +
				"   category1,          			" +
				"   phone_number1,      			" +
				"   phone_number2,      			" +
				"   e_mail1,            			" +
				"   e_mail2,            			" +
				"   post_code,          			" +
				"   address,            			" +
				"   team,               			" +
				"   birth_year,         			" +
				"   birth_month,        			" +
				"   birth_day,          			" +
				"   remarks,            			" +
				"   insert_datetime,    			" +
				"   insert_user,        			" +
				"   update_datetime,    			" +
				"   update_user         			" +
				" FROM                  			" +
				"   t_address03         			" +
				" WHERE                 			" +
				"   (CASE WHEN 						" +
				"		last_name IS NULL THEN '' 	" +
				"	ELSE 							" +
				"		last_name 					" +
				"	END) LIKE ? 					" +
				" AND                   			" +
				"   (CASE WHEN 						" +
				"		first_name IS NULL THEN '' 	" +
				"	ELSE 							" +
				"		first_name 					" +
				"	END) LIKE ? 					" +
				" AND                   			" +
				"   (CASE WHEN 						" +
				"		common_name IS NULL THEN '' " +
				"	ELSE 							" +
				"		common_name 				" +
				"	END) LIKE ? 					" +
				" AND                   			" +
				"   (CASE WHEN 						" +
				"		category1 IS NULL THEN '' 	" +
				"	ELSE 							" +
				"		category1 					" +
				"	END) LIKE ? 					" +
				" AND                   			" +
				"   (CASE WHEN 						" +
				"		team IS NULL THEN '' 		" +
				"	ELSE 							" +
				"		team 						" +
				"	END) LIKE ? 					" ;
		
		// プレースホルダの値
		String pLastName = "%" + search.getLastName() + "%";
		String pFirstName = "%" + search.getFirstName() + "%";
		String pCommonName = "%" + search.getCommonName() + "%";
		String pCategory1 = "%" + search.getCategory1() + "%";
		String pTeam = "%" + search.getTeam() + "%";
		
		// SQLで検索
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, 
				pLastName, 
				pFirstName, 
				pCommonName, 
				pCategory1,
				pTeam);
		
		// 値の取得→結果の格納
		// Map型のListをAddress型のListに変換
		List<Address> result = new ArrayList<Address>();
		for (Map<String, Object> one : list) {
			Address address = new Address();
			address.setAddressId((int)one.get("id"));
			address.setLastName((String)one.get("last_name"));
			address.setMiddleName((String)one.get("middle_name"));
			address.setFirstName((String)one.get("first_name"));
			address.setMaidenName((String)one.get("maiden_name"));
			address.setCommonName((String)one.get("common_name"));
			address.setLastNameKana((String)one.get("last_name_kana"));
			address.setMiddleNameKana((String)one.get("middle_name_kana"));
			address.setFirstNameKana((String)one.get("first_name_kana"));
			address.setMaidenNameKana((String)one.get("maiden_name_kana"));
			address.setCommonNameKana((String)one.get("common_name_kana"));
			address.setCategory1((String)one.get("category1"));
			address.setPhoneNumber1((String)one.get("phone_number1"));
			address.setPhoneNumber2((String)one.get("phone_number2"));
			address.setEMail1((String)one.get("e_mail1"));
			address.setEMail2((String)one.get("e_mail2"));
			address.setPostCode((String)one.get("post_code"));
			address.setAddress((String)one.get("address"));
			address.setTeam((String)one.get("team"));
			address.setBirthYear((Integer)one.get("birth_year"));
			address.setBirthMonth((Integer)one.get("birth_month"));
			address.setBirthDay((Integer)one.get("birth_day"));
			address.setRemarks((String)one.get("remarks"));
			result.add(address);
		}
		
		// 全件分
		return result;
	}


//	/*--- 区分リスト検索 ---*/
//	@Override
//	public List<String> selectCategoryList() {
//		
//		String sql =
//				" SELECT DISTINCT           " +
//				"   category1               " +
//				" FROM                  	" +
//				"   t_address03         	" +
//				" WHERE                 	" +
//				"	category1 IS NOT NULL	" ;
//		
//		// SQLで検索
//		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
//		
//		// 値の取得→結果の格納
//		// Map型のListをAddress型のListに変換
//		List<String> result = new ArrayList<String>();
////		result.add(null);
//		for (Map<String, Object> one : list) {
////			Address address = new Address();
////			address.setCategory1((String)one.get("category1"));
//			result.add((String)one.get("category1"));
//		}
//		
//		return result;
//	}


	/*--- 登録 ---*/
	@Override
	public void add(Address address) {
		
		String sql =
				" INSERT INTO t_address03 	" +
				" (							" +
				" 	last_name, 				" + 
				"	middle_name, 			" +
				"	first_name, 			" +
				"	maiden_name, 			" +
				"	common_name, 			" +
				" 	last_name_kana,			" +
				" 	middle_name_kana,		" +
				" 	first_name_kana,		" +
				" 	maiden_name_kana,		" +
				" 	common_name_kana,		" +
				" 	category1,				" +
				" 	phone_number1,			" +
				" 	phone_number2,			" +
				" 	e_mail1,				" +
				" 	e_mail2,				" +
				" 	post_code,				" +
				" 	address,				" +
				"	team, 					" +
				" 	birth_year,				" +
				" 	birth_month,			" +
				" 	birth_day,				" +
				" 	remarks,				" +
				"	insert_datetime, 		" +
				"	insert_user				" + 
				") 							" +
				" VALUES 					" +
				"(							" +
				"	?,						" + 
				"	?,						" + 
				"	?,						" + 
				"	?,						" + 
				"	?,						" + 
				"	?,						" + 
				"	?,						" + 
				"	?,						" + 
				"	?,						" + 
				"	?,						" + 
				"	?,						" + 
				"	?,						" + 
				"	?,						" + 
				"	?,						" + 
				"	?,						" + 
				"	?,						" + 
				"	?,						" + 
				"	?,						" + 
				"	?,						" + 
				"	?,						" + 
				"	?,						" + 
				"	?,						" + 
				" 	CURRENT_TIMESTAMP(),	" + 
				"	'test_user'				" + 
				") 							";
		
		jdbcTemplate.update(sql, 
				 address.getLastName(),
				 address.getMiddleName(),
				 address.getFirstName(),
				 address.getMaidenName(),
				 address.getCommonNameKana(),
				 address.getLastNameKana(),
				 address.getMiddleNameKana(),
				 address.getFirstNameKana(),
				 address.getMaidenNameKana(),
				 address.getCommonNameKana(),
				 address.getCategory1(),
				 address.getPhoneNumber1(),
				 address.getPhoneNumber2(),
				 address.getEMail1(),
				 address.getEMail2(),
				 address.getPostCode(),
				 address.getAddress(),
				 address.getTeam(),
				 address.getBirthYear(),
				 address.getBirthMonth(),
				 address.getBirthDay(),
				 address.getRemarks());
		
	}

	/*--- 更新 ---*/
	@Override
	public void update(Address address) {	
		
		String sql =
				" UPDATE									" +
				" 	t_address03								" +
				" SET										" +
				" 	last_name = ?,							" +
				" 	middle_name = ?,						" +
				" 	first_name = ?,							" +
				" 	maiden_name = ?,						" +
				" 	common_name = ?,						" +
				" 	last_name_kana = ?,						" +
				" 	middle_name_kana = ?,					" +
				" 	first_name_kana = ?,					" +
				" 	maiden_name_kana = ?,					" +
				" 	common_name_kana = ?,					" +
				" 	category1 = ?,							" +
				" 	phone_number1 = ?,						" +
				" 	phone_number2 = ?,						" +
				" 	e_mail1 = ?,							" +
				" 	e_mail2 = ?,							" +
				" 	post_code = ?,							" +
				" 	address = ?,							" +
				" 	team = ?,								" +
				" 	birth_year = ?,							" +
				" 	birth_month = ?,						" +
				" 	birth_day = ?,							" +
				" 	remarks = ?,							" +
				" 	update_datetime = CURRENT_TIMESTAMP(),	" +
				" 	update_user = 'test_user'				" +
				" WHERE										" +
				" 	id = ?									";
		
		jdbcTemplate.update(sql, 
				 address.getLastName(),
				 address.getMiddleName(),
				 address.getFirstName(),
				 address.getMaidenName(),
				 address.getCommonName(),
				 address.getLastNameKana(),
				 address.getMiddleNameKana(),
				 address.getFirstNameKana(),
				 address.getMaidenNameKana(),
				 address.getCommonNameKana(),
				 address.getCategory1(),
				 address.getPhoneNumber1(),
				 address.getPhoneNumber2(),
				 address.getEMail1(),
				 address.getEMail2(),
				 address.getPostCode(),
				 address.getAddress(),
				 address.getTeam(),
				 address.getBirthYear(),
				 address.getBirthMonth(),
				 address.getBirthDay(),
				 address.getRemarks(),
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
