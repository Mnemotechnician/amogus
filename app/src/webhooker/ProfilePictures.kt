package webhooker

import kotlin.random.*;

/** Provides avatar urls */
object ProfilePictures {
	
	val logInfo = "https://drive.google.com/uc?export=download&id=14SAChYgiN7uXF6lkINXMeKJcdAyRdh0U"
	val logErr = "https://drive.google.com/uc?export=download&id=14ZMt-eBx-jTQWYnjfrPS9ZCFTP9Il9CH"
	
	val avatars = listOf(
		"https://drive.google.com/uc?export=download&id=14d7asz3DKGj1F22Cq0XohtMIhpR87i8m",
		"https://drive.google.com/uc?export=download&id=14iLtbqKGaDKKOFXXfdtp2tdEHTuaXCF1",
		"https://drive.google.com/uc?export=download&id=14fq4EBermmrakV0ZRCDNhKRKj8W3xtLN",
		"https://drive.google.com/uc?export=download&id=14cGGvS3UDFPm2VuGpBsT4uKObgLCbn6I",
		"https://drive.google.com/uc?export=download&id=15A_DG6RmBf8RoMlMYRZm8aV5mLioZwwb",
		
		"https://drive.google.com/uc?export=download&id=14ePMdlYBu2gG4H7CBY0IiGUrNZkfv_Z_",
		"https://drive.google.com/uc?export=download&id=155wGnu3m6r5xk9pGAt2XMXBQDuxqyAp3",
		"https://drive.google.com/uc?export=download&id=14kxkjjBIdvJBnFMbg08H9Y3qb-aNrvoH",
		"https://drive.google.com/uc?export=download&id=14sdAb9N6QWiGe_cAaUqscWgzF1Y6FfM5",
		"https://drive.google.com/uc?export=download&id=155m644Bk-nTAetkP0DDYJJi54QgNM0f8",
		
		"https://drive.google.com/uc?export=download&id=14n-trqf0hpzTZJil2ZMbd4yMHb5bf3S-",
		"https://drive.google.com/uc?export=download&id=14cY1LROmFacdfAw7KyNx-smiRYMziXoD",
		"https://drive.google.com/uc?export=download&id=14x2S1Hrai6Z7kaaVO_v6QocQb5e9OvOP",
		"https://drive.google.com/uc?export=download&id=15-xKrdkX5jZhbf0X9rLNAshPrv54HNDK",
		"https://drive.google.com/uc?export=download&id=14sgpmdEaR81e_PO06EMrqPzYntFEVS0V"
	)
	fun random() = avatars[Random.nextInt(0, avatars.size)]
	
}