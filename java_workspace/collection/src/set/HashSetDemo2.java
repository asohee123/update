package set;

import java.util.HashSet;
import java.util.Iterator;

import vo.Product;

public class HashSetDemo2 {

	public static void main(String[] args) {
		
		HashSet<Product> product = new HashSet<Product>();
		
		Product p1 = new Product(100, "집", "모나미", 3000);
		Product p2 = new Product(101, "가", "모나미", 7000);
		Product p3 = new Product(102, "고", "모나미", 7000);
		Product p4 = new Product(103, "싶", "모나미", 5000);
		Product p5 = new Product(104, "다", "모나미", 4000);
		
		product.add(p1);
		product.add(p2);
		product.add(p3);
		product.add(p4);
		product.add(p5);
		
		Iterator<Product> itr = product.iterator();
		while(itr.hasNext()) {
			Product p = itr.next();
			if(p.getPrice() >= 5000) {
				itr.remove();
			}
		}
		
		
		int size = product.size();
		
		System.out.println("저장된 갯수 : " + size);

		for(Product p : product) {
			System.out.println(p.getNo() +", " + p.getName() + ", " + p.getPrice());
		}
		
		System.out.println(product);

	}
}
