package semi.vo;

public class Pagination {

	private int rowsPerPage;
	private int pagesPerBlock;
	private int pageNo;
	private int totalRows;
	private int totalPages;
	private int totalBlocks;
	private int currentBlock;
	private int beginIndex;
	private int endIndex;
	private int beginPage;
	private int endPage;
	
	public Pagination(int rowsPerPage, int pagesPerBlock, int pageNo, int totalRows) {
		this.rowsPerPage = rowsPerPage;
		this.pagesPerBlock = pagesPerBlock;
		this.pageNo = pageNo;
		this.totalRows = totalRows;
		
		init();
	}
	
	private void init() {
		totalPages = (int) Math.ceil((double) totalRows/rowsPerPage);
		
		if (pageNo < 0 || pageNo > totalPages) {
			pageNo = 1;
		}
		beginIndex = (pageNo - 1)*rowsPerPage + 1;
		endIndex = pageNo*rowsPerPage;
		totalBlocks = (int) Math.ceil((double) totalPages/pagesPerBlock);
		currentBlock = (int) Math.ceil((double) pageNo/pagesPerBlock);
		beginPage = (currentBlock - 1)*pagesPerBlock + 1;
		endPage = currentBlock*pagesPerBlock;
		if (currentBlock == totalBlocks) {
			endPage = totalPages;
		}
	}
	
	public int getPageNo() {
		return pageNo;
	}
	
	public int getTotalPages() {
		return totalPages;
	}
	
	public int getBeginIndex() {
		return beginIndex;
	}
	
	public int getEndIndex() {
		return endIndex;
	}
	
	public int getBeginPage() {
		return beginPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
}
