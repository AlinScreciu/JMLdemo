 /**
 * Client class which is used for testing the program
 * 
 */
public class Client {

	public static void main(String[] args) {
		System.out.println("-------- Testing Cash --------");
		Cash cash = new Cash(1000);
		System.out.println("The amount of cash loaded is $"+cash.amount());
		System.out.println("Have you been loaded onto a gift card? "+cash.loaded());

		
		System.out.println("\n");
		System.out.println("-------- Testing GiftCard --------");
		System.out.println("Loading $1000 onto a gift card");
		GiftCard giftCard = new GiftCard(cash);
		System.out.println("Have you been loaded onto a gift card? "+cash.loaded());
		System.out.println("The available balance in the giftcard is $"+giftCard.balance());
		System.out.println("Can this be used to make a purchase? "+giftCard.canUseForPurchase());
		System.out.println("Making a purchase for $500");
		if(giftCard.canUseForPurchase()) {
			giftCard.purchase(500);
		}
		System.out.println("The available balance in the giftcard is $"+giftCard.balance());

		
		System.out.println("\n");
		System.out.println("-------- Testing SingleUseGiftCard --------");
		System.out.println("Loading $1000 money onto a SingleUseGift card");
		SingleUseGiftCard singleUseGiftCard = new SingleUseGiftCard(cash);
		System.out.println("The available balance in the single use giftcard is $"+singleUseGiftCard.balance());
		System.out.println("Making a purchase of 500 dollars!");
		if(singleUseGiftCard.canUseForPurchase()) {
			singleUseGiftCard.purchase(500);
		}
		System.out.println("The available balance in the single use giftcard is $"+singleUseGiftCard.balance());
		System.out.println("Making another purchase with the singleusegiftcard");
		if(singleUseGiftCard.canUseForPurchase()) {
			singleUseGiftCard.purchase(500);
		}else {
			System.out.println("The giftcard is for single time use only");
		}

		
		System.out.println("\n");
		System.out.println("-------- Testing Reloadable Gift Card --------");
		System.out.println("Loading $1000 money onto a ReloadableGiftCard");
		ReloadableGiftCard reloadableGiftCard = new ReloadableGiftCard();
		reloadableGiftCard.load(cash);
		System.out.println("The available balance in the reloadable use giftcard is $"+reloadableGiftCard.balance());
		if(reloadableGiftCard.canUseForPurchase()) {
			reloadableGiftCard.purchase(500);
		}
		System.out.println("The available balance in the reloadable giftcard is $"+reloadableGiftCard.balance());
		System.out.println("Making another $500 purchase with the ReloadableGiftCard");
		if(reloadableGiftCard.canUseForPurchase()) {
			reloadableGiftCard.purchase(500);
		}
		System.out.println("The available balance in the reloadable giftcard is $"+reloadableGiftCard.balance());

		
		System.out.println("\n");
		System.out.println("-------- Testing loading cash from one gift card to another --------");
		Cash cash1 = new Cash(200);
		Cash cash2 = new Cash(300);
		GiftCard giftCard1 = new GiftCard(cash1);
		GiftCard giftCard2 = new GiftCard(cash2);
		giftCard1.absorb(giftCard2);
		System.out.println("The available balance in the first giftcard is $"+giftCard1.balance());
		System.out.println("The available balance in the second giftcard is $"+giftCard2.balance());

		
		System.out.println("\n");
		System.out.println("-------- Testing loading cash into the debit card  --------");
		DebitCard debitCard = new DebitCard(cash);
		System.out.println("The available balance in the debitcard is $"+debitCard.balance());
		debitCard.convert(500);
		System.out.println("The available balance in the debitcard is $"+debitCard.balance());
		System.out.println("Have you ever converted any of your balance to cash?"+debitCard.converted());
		System.out.println("The converted cash amount is $"+debitCard.lastCash().amount());
	}

}
