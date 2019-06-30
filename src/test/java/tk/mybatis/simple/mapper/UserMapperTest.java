package tk.mybatis.simple.mapper;

//import java.io.IOException;
//import java.io.Reader;
import java.util.List;

//import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.junit.BeforeClass;
import org.junit.Test;

import tk.mybatis.simple.model.Country;
import tk.mybatis.simple.model.SysUser;

public class UserMapperTest extends BaseMapperTest {

@Test
public void testSelectById(){
	SqlSession sqlSession = getSqlSession();
	try {
	UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
	SysUser user = userMapper.selectById((long) 1);
	Assert.assertNotNull(user);
	Assert.assertEquals("admin", user.getUserName());
	} finally {
	//不要忘记关闭sqlSession
	sqlSession.close() ;
	}
}

@Test
public void testSelectAll(){
	SqlSession sqlSession = getSqlSession();
	try {
	UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
	List<SysUser> userlist = userMapper.selectAll();
	Assert.assertNotNull(userlist);
	Assert.assertTrue(userlist.size()>0);
	} finally {
	//不要忘记关闭sqlSession
	sqlSession.close() ;
	}
}
}
/*package tk.mybatis.simple.mapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import tk.mybatis.simple.model.Country;

public class CountryMapperTest {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	@BeforeClass
	public static void init(){
		try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException ignore) {
        	ignore.printStackTrace();
        }
	}
	
	@Test
	public void testSelectAll(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			List<Country> countryList = sqlSession.selectList("selectAll");
			printCountryList(countryList);
		} finally {
			sqlSession.close();
		}
	}
	
	private void printCountryList(List<Country> countryList){
		for(Country country : countryList){
			System.out.printf("%-4d%4s%4s\n",country.getId(), country.getCountryname(), country.getCountrycode());
		}
	}
}
*/