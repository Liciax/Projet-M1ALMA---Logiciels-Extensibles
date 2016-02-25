package donnees;

import java.util.Vector;

public class Stock {
	
	private Vector<Produit> stockProduit;
	
	/**
	 * @param stockProduit
	 */
	public Stock() {
		this.stockProduit = new Vector<Produit>();
		
	}


	/**
	 * @return the stockProduit
	 */
	public Vector<Produit> getStockProduit() {
		return stockProduit;
	}

	/**
	 * @param stockProduit the stockProduit to set
	 */
	public void setStockProduit(Vector<Produit> stockProduit) {
		this.stockProduit = stockProduit;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Stock [stockProduit=" + stockProduit + "]";
	}
	
}
