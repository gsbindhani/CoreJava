package com.coreJava.test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.SortOrder;

import dnl.utils.text.table.TextTable;

public class Main implements Constants {
	
	private static final List<PortfolioVo> portFplio = new ArrayList<>();
	private static final Map<String, List<MFvo>> mfMap = new TreeMap<>();
	
	private static final String url = "https://www.amfiindia.com/spages/NAVAll.txt";
	private static final String location = "C:\\Users\\Milu\\Desktop\\New folder\\NAVAll.txt";
	private static final String[] colmuns = {"SchemeName","Investments","LatestValue","Profit/Loss", "Percentage(%)","IsELSS"};
	private static String[][] data;
	
	private static final DecimalFormat df = new DecimalFormat("#.000");
	private static final DecimalFormat pdf = new DecimalFormat("#.00");
	
	static double totalValue = 0.0;
	static double currentValue = 0.0;
	static double totalInElss = 0.0;
	static double currentInElss = 0.0;
	static String date = null;
	
	public static void main(String[] args) throws IOException {
		//downloadNavList(url, location);
		parseNavList();
		loadPortfolio();
		showortfolio();
	}
	
	
	private static void downloadNavList(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }
	
	private static void parseNavList(){
		List<MFvo> mFvos = null;
		URL navUrl;
		try {
			navUrl = new URL(url);
			BufferedReader in = new BufferedReader(
	                new InputStreamReader(navUrl.openStream()));

	                String sCurrentLine;
	                boolean firstLine = true;
	    			while ((sCurrentLine = in.readLine()) != null) {
	    				if(firstLine || sCurrentLine == null || sCurrentLine.trim().length() == 0){
	    					firstLine = false;
	    					continue;
	    				}
	    				
	    				String[] mfs = sCurrentLine.split(";");
	    				if(mfs == null || mfs.length < 8){
	    					if(mfMap.containsKey(sCurrentLine)){
	    						mFvos = mfMap.get(sCurrentLine);
	    					}else{
	    						mFvos = new ArrayList<MFvo>();
	    						mfMap.put(sCurrentLine, mFvos);
	    					}
	    					
	    				}else if(mfs != null && mfs.length ==8){
	    					try {
	    						MFvo mFvo = new MFvo();
	    						mFvo.setSchemeCode(mfs[0]);
	    						mFvo.setiSINDivPayout_ISINGrowth(mfs[1]);
	    						mFvo.setiSINDivReinvestment(mfs[2]);
	    						mFvo.setSchemeNm(mfs[3]);
	    						mFvo.setSchemeName(mfs[3].replaceAll("\\s",""));
	    						mFvo.setNetAssetValue(Double.valueOf(mfs[4]));
	    						mFvo.setRepurchasePrice(Double.valueOf(mfs[5]));
	    						mFvo.setSalePrice(Double.valueOf(mfs[6]));
	    						mFvo.setDate(mfs[7]);
	    						mFvos.add(mFvo);
	    					} catch (Exception e) {}
	    				}
	    			}
	                in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
//	private static void parseNavList(){
//		
//		List<MFvo> mFvos = null;
//		BufferedReader br = null;
//		FileReader fr = null;
//		try {
//			fr = new FileReader(location);
//			br = new BufferedReader(fr);
//			String sCurrentLine;
//
//			
//			boolean firstLine = true;
//			while ((sCurrentLine = br.readLine()) != null) {
//				if(firstLine || sCurrentLine == null || sCurrentLine.trim().length() == 0){
//					firstLine = false;
//					continue;
//				}
//				
//				String[] mfs = sCurrentLine.split(";");
//				if(mfs == null || mfs.length < 8){
//					if(mfMap.containsKey(sCurrentLine)){
//						mFvos = mfMap.get(sCurrentLine);
//					}else{
//						mFvos = new ArrayList<MFvo>();
//						mfMap.put(sCurrentLine, mFvos);
//					}
//					
//				}else if(mfs != null && mfs.length ==8){
//					try {
//						MFvo mFvo = new MFvo();
//						mFvo.setSchemeCode(mfs[0]);
//						mFvo.setiSINDivPayout_ISINGrowth(mfs[1]);
//						mFvo.setiSINDivReinvestment(mfs[2]);
//						mFvo.setSchemeNm(mfs[3]);
//						mFvo.setSchemeName(mfs[3].replaceAll("\\s",""));
//						mFvo.setNetAssetValue(Double.valueOf(mfs[4]));
//						mFvo.setRepurchasePrice(Double.valueOf(mfs[5]));
//						mFvo.setSalePrice(Double.valueOf(mfs[6]));
//						mFvo.setDate(mfs[7]);
//						mFvos.add(mFvo);
//					} catch (Exception e) {}
//				}
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	private static void loadPortfolio(){
		portFplio.add( new PortfolioVo(ADITYA_BRILA_SUN_LIFE, "AdityaBirlaSunLifeTaxRelief'96-Growth-DirectPlan", 31.55, 792.393,true));
		portFplio.add( new PortfolioVo(ICICI_PRUDENTIAL, "ICICIPrudentialTop100Fund-DirectPlan-Growth", 310.26, 16.116,false));
		portFplio.add( new PortfolioVo(LT_MUTUAL_FUND, "L&TMidCapFund-DirectPlan-Growth", 149.50, 100.334,false));
		portFplio.add( new PortfolioVo(LT_MUTUAL_FUND, "L&TTaxAdvantageFund-DirectPlan-Growth", 56.9940, 350.914,true));

		portFplio.add( new PortfolioVo(LT_MUTUAL_FUND, "L&TTaxAdvantageFund-RegularPlan-Growth", 49.8912, 120.2620,true));
		portFplio.add( new PortfolioVo(ADITYA_BRILA_SUN_LIFE, "AdityaBirlaSunLifeTaxRelief'96-GrowthOption", 23.6675, 126.7560,true));
		portFplio.add( new PortfolioVo(AXIS_MUTUAL_FUND, "AxisLongTermEquityFund-Growth", 33.8903, 177.0420,true));
		portFplio.add( new PortfolioVo(DSP_BLACKROCK_MUTUAL_FUND, "DSPBlackRockTaxSaverFund-RegularPlan-Growth", 42.6272, 140.7550,true));
		
	}

	private static void showortfolio(){
		
		data = new String[portFplio.size()+4][6];

		PortfolioVo portFolioVo = null;
		MFvo mFvo = null;
		
		for (int i = 0; i < portFplio.size(); i++) {
			portFolioVo = portFplio.get(i);
			for (int j = 0; j < mfMap.get(portFolioVo.getFundFamily()).size(); j++){
				mFvo = mfMap.get(portFolioVo.getFundFamily()).get(j);
				if(portFolioVo.getSchemeName().equalsIgnoreCase(mFvo.getSchemeName())){
					double investmentVal = portFolioVo.getQuantity() * portFolioVo.getPurchasePrice();
					double currentPrice = portFolioVo.getQuantity() * mFvo.getNetAssetValue();
					double profitLoss = currentPrice - investmentVal;
					
					data[i][0] = mFvo.getSchemeNm();
					data[i][1] = String.valueOf(df.format(investmentVal));
					data[i][2] = String.valueOf(df.format(currentPrice));
					data[i][3] = String.valueOf(df.format(profitLoss));
					data[i][4] = String.valueOf(pdf.format((profitLoss/investmentVal) * 100));
					data[i][5] = portFolioVo.isElss()+"";
					
					totalValue += investmentVal;
					currentValue += currentPrice;
					
					if(portFolioVo.isElss()){
						totalInElss += investmentVal;
						currentInElss += currentPrice;
					}
					
					date = mFvo.getDate();
				}
			}
		}
		
//		portFplio.forEach(portFolioVo -> {
//			mfMap.get(portFolioVo.getFundFamily()).forEach(mFvo -> {
//				if(mFvo.getSchemeName().equalsIgnoreCase(portFolioVo.getSchemeName())){
//				double investmentVal = portFolioVo.getQuantity() * portFolioVo.getPurchasePrice();
//				double currentPrice = portFolioVo.getQuantity() * mFvo.getNetAssetValue();
//				
//				
//				System.out.print(portFolioVo.getSchemeName()+"-Investment: "
//						+ ""+df.format(investmentVal) + ", CurrentPrice :"+df.format(currentPrice));
//				totalValue += investmentVal;
//				currentValue += currentPrice;
//				}
//			});
//			System.out.println();
//		});
//		
//		System.out.print("totalValue: "+df.format(totalValue) + ", currentValue: "+df.format(currentValue));
		
		data[portFplio.size()][0] = "";
		
		data[portFplio.size()+1][0] = "In Elss";
		data[portFplio.size()+1][1] = String.valueOf(df.format(totalInElss)); 
		data[portFplio.size()+1][2] = String.valueOf(df.format(currentInElss)); 
		data[portFplio.size()+1][3] = String.valueOf(df.format(currentInElss - totalInElss)); 
		data[portFplio.size()+1][4] = String.valueOf(pdf.format(((currentInElss - totalInElss)/totalInElss) * 100)); 
		
		double totalInOthers = totalValue - totalInElss;
		double currentInOthers = currentValue - currentInElss;
		
		data[portFplio.size()+2][0] = "In Others";
		data[portFplio.size()+2][1] = String.valueOf(df.format(totalInOthers)); 
		data[portFplio.size()+2][2] = String.valueOf(df.format(currentInOthers)); 
		data[portFplio.size()+2][3] = String.valueOf(df.format(currentInOthers - totalInOthers)); 
		data[portFplio.size()+2][4] = String.valueOf(pdf.format(((currentInOthers - totalInOthers)/totalInOthers) * 100)); 
		
		data[portFplio.size()+3][0] = "Total";
		data[portFplio.size()+3][1] = String.valueOf(df.format(totalValue)); 
		data[portFplio.size()+3][2] = String.valueOf(df.format(currentValue)); 
		data[portFplio.size()+3][3] = String.valueOf(df.format(currentValue - totalValue)); 
		data[portFplio.size()+3][4] = String.valueOf(pdf.format(((currentValue - totalValue)/totalValue) * 100)); 
		
		System.out.println();
		System.out.println("Date -"+date);
		
		TextTable tt = new TextTable(colmuns, data);
		tt.setSort(5, SortOrder.DESCENDING);
		tt.printTable();
	}
}

class MFvo{
	private String schemeCode;
	private String iSINDivPayout_ISINGrowth;
	private String iSINDivReinvestment;
	private String schemeName;
	private double netAssetValue;
	private double repurchasePrice;
	private double salePrice;
	private String date;
	private String schemeNm;
	
	public String getSchemeCode() {
		return schemeCode;
	}

	public void setSchemeNm(String schemeNm) {
		this.schemeNm = schemeNm;
	}
	public String getSchemeNm() {
		return schemeNm;
	}

	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
	}
	public String getiSINDivPayout_ISINGrowth() {
		return iSINDivPayout_ISINGrowth;
	}
	public void setiSINDivPayout_ISINGrowth(String iSINDivPayout_ISINGrowth) {
		this.iSINDivPayout_ISINGrowth = iSINDivPayout_ISINGrowth;
	}
	public String getiSINDivReinvestment() {
		return iSINDivReinvestment;
	}
	public void setiSINDivReinvestment(String iSINDivReinvestment) {
		this.iSINDivReinvestment = iSINDivReinvestment;
	}
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	public double getNetAssetValue() {
		return netAssetValue;
	}
	public void setNetAssetValue(double netAssetValue) {
		this.netAssetValue = netAssetValue;
	}
	public double getRepurchasePrice() {
		return repurchasePrice;
	}
	public void setRepurchasePrice(double repurchasePrice) {
		this.repurchasePrice = repurchasePrice;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return schemeName;
	}
}


class PortfolioVo{
	private String fundFamily;
	private String schemeName;
	private double purchasePrice;
	private double quantity;
	private boolean isElss;
	
	
	
	public PortfolioVo(String fundFamily, String schemeName, double purchasePrice, double quantity, boolean isElss) {
		super();
		this.fundFamily = fundFamily;
		this.schemeName = schemeName;
		this.purchasePrice = purchasePrice;
		this.quantity = quantity;
		this.isElss = isElss;
	}
	public String getFundFamily() {
		return fundFamily;
	}
	public void setFundFamily(String fundFamily) {
		this.fundFamily = fundFamily;
	}
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public boolean isElss() {
		return isElss;
	}
	public void setElss(boolean isElss) {
		this.isElss = isElss;
	}
}


interface Constants{
	String ADITYA_BRILA_SUN_LIFE = "Aditya Birla Sun Life Mutual Fund";
	String ICICI_PRUDENTIAL = "ICICI Prudential Mutual Fund";
	String LT_MUTUAL_FUND = "L&T Mutual Fund";
	String AXIS_MUTUAL_FUND = "Axis Mutual Fund";
	String DSP_BLACKROCK_MUTUAL_FUND = "DSP BlackRock Mutual Fund";
}