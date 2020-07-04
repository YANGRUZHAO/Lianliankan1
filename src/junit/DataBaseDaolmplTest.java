package junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dao.impl.DataBaseDaolmpl;
import test.Player;

public class DataBaseDaolmplTest {

	DataBaseDaolmpl dbdi;

	@Before
	public void init() {
		this.dbdi = new DataBaseDaolmpl();
	}

	@Test
	public void testQuery() {
		assertEquals(dbdi.query("123456", "123456"), true);
	}


	@Test
	public void testInsert() {
		assertEquals(dbdi.insert(new Player("123456", "111111")), false); // 插入一个已经存在的账号
	}
}
