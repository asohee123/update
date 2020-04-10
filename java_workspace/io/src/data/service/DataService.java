package data.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeMap;

import data.repo.DataRepo;
import data.vo.Data;

public class DataService {

	private DataRepo repo;
	
	public DataService() throws Exception{
		
		repo = new DataRepo();

	}
	
	//	전체 사고건수, 사망자수를 출력하는 기능
	public void printAllDataCount() {
		List<Data> datas = repo.getAllData();
		
		int totalDeath = 0;
		for(Data data : datas) {
			totalDeath += data.getDeath();
		}
		System.out.println("전체 사고건수 : " + datas.size());
		System.out.println("전체 사망자수 : " + totalDeath);
		
	}
	//	시도를 전달받아서 해당 지역의 사고건수와 사망자수를 출력하는 기능
	public void printDataBysido(String sido) {
		List<Data> datas = repo.getDataBysido(sido);
		
		int totalDeath = 0;
		
		for(Data data : datas) {
			totalDeath += data.getDeath();
		}
		System.out.println("["+ sido + "] 지역 사고 현황");
		System.out.println("사고건수 : " + datas.size());
		System.out.println("사망자수 : " + totalDeath);
		
	}
	//	날짜를 전달받아서 해당 날짜의 사고건수와 사망자수를 출력하는 기능
	public void printDataByDay(String day) {
		List<Data> datas = repo.getDataByDay(day);
		
		int totalDeath = 0;
		
		for(Data data : datas) {
			totalDeath += data.getDeath();
		}
		System.out.println("["+ day + "] 지역 사고 현황");
		System.out.println("사고건수 : " + datas.size());
		System.out.println("사망자수 : " + totalDeath);
		
	}
	
	//	시도를 전달받아서 해당 지역의 구군별 사고현황 통계를 출력하는 기능
	public void printDataStatBySido(String sido) {
		List<Data> datas = repo.getDataBysido(sido);
		
		TreeMap<String, Stat> map = new TreeMap<String, Stat>();
		
		for(Data data : datas) {
			String gugun = data.getGugun();
			int death = data.getDeath();
			
			if(map.containsKey(gugun)) {
				Stat stat = map.get(gugun);
				stat.setRecords(stat.getRecords()+1);
				stat.setDeaths(stat.getDeaths()+death);
			} else {
				Stat stat = new Stat();
				stat.setRecords(1);
				stat.setDeaths(death);
				
				map.put(gugun, stat);
			}
		}
		
		NavigableSet<String> set = map.navigableKeySet();
		System.out.println("[구군] 사고건수 사망자수");
		for(String key : set) {
			Stat stat = map.get(key);
			System.out.println("["+key+"]" + stat.getRecords() + " " + stat.getDeaths());
			
		}
		
	}
	
	//	월별 사고현황 통계를 출력하는 기능
	public void printDataStatByMonth() {
		List<Data> datas = repo.getAllData();
		TreeMap<Integer, Stat> stats = new TreeMap<Integer, Stat>();
		
		for(Data data : datas) {
			String day = data.getDay(); // "01-01", "05-07", "11-15",
			String monthString = day.substring(0, 2);	//"01" "01" "02" "02"
			int month = 0;
			
			if(monthString.startsWith("0")) {		//0으로 시작하게 된다면
				month = Integer.parseInt(monthString.substring(1)); // 01 -> 1월
			} else {										//앞 0을 자른다는 뜻
				month = Integer.parseInt(monthString);		// 12월 그대로
			}
			
			Stat savedStat = stats.get(month);			//Map에서 month를 key로 Stat객체를 조회한다.
			if(savedStat == null) {							//m으로 저장된 Stat객체가 없으면
				Stat stat = new Stat();						//Stat객체를 생성한다.
				stat.setDeaths(data.getDeath());			//사망자수와 사고건수를 담아서
				stat.setRecords(1);
				
				stats.put(month, stat);					//Map에 month로 Stat를 저장한다.
			} else {										//List m-1번째에 저장된 Stat객체가 있으면
				savedStat.setDeaths(savedStat.getDeaths() + data.getDeath());
				savedStat.setRecords(savedStat.getRecords() + 1);
			}
			
			}
			System.out.println("월\t사고건수\t사망자수");
			System.out.println("==========================");
			int size = stats.size();
			for(int i = 1; i<=size; i++) {
				Stat stat = stats.get(i);
				System.out.println((i) + "월\t" + stat.getRecords() + "\t" + stat.getDeaths() );
		}
	}
	
	//	요일별 사고현황 통계를 출력하는 기능
	public void printDataStatByDayOfWeek() {
		
	}
	
	//위반내용별 사고현황 통계를 출력하는 기능
	public void printDataStatByViolation(){
		// TODO Auto-generated method stubk
		
	}
	
	// 사고현황 요약 결과를 출력하는 기능
	public void printDataStat() {
		
	}
	
	class Stat{
		
		private int records;
		private int deaths;
		
		public Stat() {}
			

		public int getRecords() {
			return records;
		}

		public void setRecords(int records) {
			this.records = records;
		}

		public int getDeaths() {
			return deaths;
		}

		public void setDeaths(int deaths) {
			this.deaths = deaths;
		}
	}
	
}
