package collection.demo;

import java.util.ArrayList;

import vo.Product;

public class ProductRepository {

		ArrayList<Product> db = new ArrayList<Product>();
		
		//새상품 등록
		public void insertProduct(Product product) {
			
		}
		//등록된 모든 상품을 반환하는 기능
		public ArrayList<Product> getAllProducts(){
			return null;
		}
		//전달받은 번호에 해당하는 상품을 반환하는 기능
		public Product getProductByNo(int productNo) {
			return null;
		}
		//전달받은 상푸명에 해당하는 상품을 반환하는 기능
		public ArrayList<Product> searchProducts(String productName){
			return null;
		}
		//전달받은 상품번호에 해당하는 상품을 삭제하는 기능
		public void deleteProduct(int productNo) {
			
		}
	
}