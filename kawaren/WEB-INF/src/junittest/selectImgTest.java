package junittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.ImgDAO;

class selectImgTest {

	@Test
	public void testSelectImg() {
		byte[] imgdata = ImgDAO.selectImg("2022-06-07-14-46-05.jpg");
		assertTrue(imgdata.length ==1557291 );
	}

}
