package android.ptc.com.ptcflixing

import android.ptc.com.ptcflixing.model.product.ProductResponse
import com.google.gson.Gson

object MockData {
    val configuraton="{\n" +
            "  \"success\": true,\n" +
            "  \"session\": {\n" +
            "    \"id\": \"75h2uecflq49ohiet1nkdpj9n1\",\n" +
            "    \"expire\": null,\n" +
            "    \"YII_CSRF_TOKEN\": \"c5f9d473938963251461901ad4cece609a5e04c3\"\n" +
            "  },\n" +
            "  \"metadata\": {\n" +
            "    \"currency\": {\n" +
            "      \"iso\": \"NGN\",\n" +
            "      \"currency_symbol\":\"\\u20a6\",\n" +
            "      \"position\": 0,\n" +
            "      \"decimals\": 0,\n" +
            "      \"thousands_sep\": \",\",\n" +
            "      \"decimals_sep\": \".\"\n" +
            "    },\n" +
            "    \"languages\": [\n" +
            "      {\n" +
            "        \"code\": \"en_NG\",\n" +
            "        \"name\": \"English\",\n" +
            "        \"default\": true\n" +
            "      }\n" +
            "    ],\n" +
            "    \"support\": {\n" +
            "      \"phone_number\": \"123456789\",\n" +
            "      \"call_to_order_enabled\": false,\n" +
            "      \"cs_email\": \"test@jumia.com.ng\"\n" +
            "    }\n" +
            "  }\n" +
            "}"

    val productDetails= "{\n" +
            "    \"success\": true,\n" +
            "    \"metadata\": {\n" +
            "      \"sku\": \"1\",\n" +
            "      \"name\": \"Samsung Galaxy S9\",\n" +
            "      \"max_saving_percentage\": 30,\n" +
            "      \"price\": 53996,\n" +
            "      \"special_price\": 37990,\n" +
            "      \"brand\": \"Samsung\",\n" +
            "      \"rating\": {\n" +
            "        \"average\": 4,\n" +
            "        \"ratings_total\": 265\n" +
            "      },\n" +
            "      \"image_list\": [\n" +
            "        \"https://cdn2.gsmarena.com/vv/bigpic/samsung-galaxy-s9-.jpg\",\n" +
            "        \"https://cdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s9-1.jpg\",\n" +
            "        \"https://cdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s9-burgundy-red.jpg\",\n" +
            "        \"https://cdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s9-2.jpg\",\n" +
            "        \"https://cdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-s9-2.jpg\"\n" +
            "      ],\n" +
            "      \"summary\": {\n" +
            "        \"short_description\": \"- 5.2 Inch 2.5D IPS Corning Gorilla Glass 3 Screen\\n - MTK6737T 1.5GHz Quad Core\\n - 3GB RAM + 32GB ROM\\n - 13 MP Back Camera + 16 MP Front Camera with Selfie Flash\\n -  Android 7.0 System\\n - 4000mAh Battery\",\n" +
            "        \"description\": \"- 5.2 Inch 2.5D IPS Corning Gorilla Glass 3 Screen, 1280*720 Pixel- MTK6737T 1.5GHz Quad Core- Support Touch ID- 3GB RAM + 32GB ROM, Support 256GB TF Card Expansion- 13 MP Back Camera + 16 MP Front Camera with Selfie Flash- Amigo OS 4.0 ( Based On Android 7.0 System)- 4000mAh Battery.- Support Fingerprint Shutter, IR Remote Control, Image+, Ami Clone, Split Screen, Theme Park,Three Individual Slots etc.- Dual SIM: NANO SIM + NANO SIM + TF Card, three Card Slot.- Band: GSM 850/900/1800/1900MHz, WCDMA 850/900/1900/2100MHz, FDD-LTE B1/B3/B7/B8/B20, Support 2G & 3G & 4G LTE Network.-Language:English, German, Spanish, Italian, French, Portuguese, Thai, Arabic, Turkish, Vietnamese, Malay, Chinese (simplified), Chinese (traditional), And Etc...\"\n" +
            "      },\n" +
            "      \"seller_entity\": {\n" +
            "        \"id\": 52863,\n" +
            "        \"name\": \"iTechStor\",\n" +
            "        \"delivery_time\": \"Shipped from overseas. Delivered by Thursday 14 Jun\"\n" +
            "      }\n" +
            "    }\n" +
            "  }"

    val productList= "{\n" +
            "  \"success\": true,\n" +
            "  \"metadata\": {\n" +
            "    \"sort\": \"POPULARITY\",\n" +
            "    \"total_products\": 20,\n" +
            "    \"title\": \"Phones & Tablets\",\n" +
            "    \"results\": [\n" +
            "      {\n" +
            "        \"sku\": \"1\",\n" +
            "        \"name\": \"Samsung Galaxy S9\",\n" +
            "        \"brand\": \"Samsung\",\n" +
            "        \"max_saving_percentage\": 30,\n" +
            "        \"price\": 53996,\n" +
            "        \"special_price\": 37990,\n" +
            "        \"image\": \"https://cdn2.gsmarena.com/vv/bigpic/samsung-galaxy-s9-.jpg\",\n" +
            "        \"rating_average\": 5\n" +
            "      },\n" +
            "      {\n" +
            "        \"sku\": \"2\",\n" +
            "        \"name\": \"Huawei P20 Pro\",\n" +
            "        \"brand\": \"Huawei\",\n" +
            "        \"max_saving_percentage\": 45,\n" +
            "        \"price\": 43899,\n" +
            "        \"special_price\": 23990,\n" +
            "        \"image\": \"https://cdn2.gsmarena.com/vv/bigpic/huawei-p20-pro-.jpg\",\n" +
            "        \"rating_average\": 4\n" +
            "      },\n" +
            "      {\n" +
            "        \"sku\": \"3\",\n" +
            "        \"name\": \"M7 5.5\\\" HD Android 7.0 Quad Core Back Cams(8MP+5MP) Front 5MP 1GB RAM 16GB ROM Fingerprint 3G Smartphone-Gold\",\n" +
            "        \"brand\": \"LEAGOO\",\n" +
            "        \"max_saving_percentage\": 17,\n" +
            "        \"price\": 30000,\n" +
            "        \"special_price\": 24990,\n" +
            "        \"image\": \"https://cdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-nexus-new.jpg\",\n" +
            "        \"rating_average\": 1\n" +
            "      },\n" +
            "      {\n" +
            "        \"sku\": \"4\",\n" +
            "        \"name\": \"T5 5.5\\\" FHD 4GB RAM 64GB ROM Back 13MP+5MP Front 13MP Cams Android 7.0 MT6750T Octa Core 1.5GHz Front Fingerprint 4G LTE Smartphone-Gold\",\n" +
            "        \"brand\": \"LEAGOO\",\n" +
            "        \"max_saving_percentage\": 23,\n" +
            "        \"price\": 60000,\n" +
            "        \"special_price\": 45990,\n" +
            "        \"image\": \"https://cdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-nexus-new.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"sku\": \"5\",\n" +
            "        \"name\": \"T5 5.5\\\" FHD 4GB RAM 64GB ROM Back 13MP+5MP Front 13MP Cams Android 7.0 MT6750T Octa Core 1.5GHz Front Fingerprint 4G LTE Smartphone-Gold\",\n" +
            "        \"brand\": \"LEAGOO\",\n" +
            "        \"max_saving_percentage\": 23,\n" +
            "        \"price\": 60000,\n" +
            "        \"special_price\": 45990,\n" +
            "        \"image\": \"https://cdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-nexus-new.jpg\",\n" +
            "        \"rating_average\": 3\n" +
            "      },\n" +
            "      {\n" +
            "        \"sku\": \"6\",\n" +
            "        \"name\": \"T5 5.5\\\" FHD 4GB RAM 64GB ROM Back 13MP+5MP Front 13MP Cams Android 7.0 MT6750T Octa Core 1.5GHz Front Fingerprint 4G LTE Smartphone-Gold\",\n" +
            "        \"brand\": \"LEAGOO\",\n" +
            "        \"max_saving_percentage\": 23,\n" +
            "        \"price\": 60000,\n" +
            "        \"special_price\": 45990,\n" +
            "        \"image\": \"https://cdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-nexus-new.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"sku\": \"7\",\n" +
            "        \"name\": \"T5 5.5\\\" FHD 4GB RAM 64GB ROM Back 13MP+5MP Front 13MP Cams Android 7.0 MT6750T Octa Core 1.5GHz Front Fingerprint 4G LTE Smartphone-Gold\",\n" +
            "        \"brand\": \"LEAGOO\",\n" +
            "        \"max_saving_percentage\": 23,\n" +
            "        \"price\": 66000,\n" +
            "        \"special_price\": 45990,\n" +
            "        \"image\": \"https://cdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-nexus-new.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"sku\": \"8\",\n" +
            "        \"name\": \"T5 5.5\\\" FHD 4GB RAM 64GB ROM Back 13MP+5MP Front 13MP Cams Android 7.0 MT6750T Octa Core 1.5GHz Front Fingerprint 4G LTE Smartphone-Gold\",\n" +
            "        \"brand\": \"LEAGOO\",\n" +
            "        \"max_saving_percentage\": 23,\n" +
            "        \"price\": 60000,\n" +
            "        \"special_price\": 45990,\n" +
            "        \"image\": \"https://cdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-nexus-new.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"sku\": \"9\",\n" +
            "        \"name\": \"T5 5.5\\\" FHD 4GB RAM 64GB ROM Back 13MP+5MP Front 13MP Cams Android 7.0 MT6750T Octa Core 1.5GHz Front Fingerprint 4G LTE Smartphone-Gold\",\n" +
            "        \"brand\": \"LEAGOO\",\n" +
            "        \"max_saving_percentage\": 23,\n" +
            "        \"price\": 70000,\n" +
            "        \"special_price\": 45990,\n" +
            "        \"image\": \"https://cdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-nexus-new.jpg\",\n" +
            "        \"rating_average\": 4\n" +
            "      },\n" +
            "      {\n" +
            "        \"sku\": \"10\",\n" +
            "        \"name\": \"T5 5.5\\\" FHD 4GB RAM 64GB ROM Back 13MP+5MP Front 13MP Cams Android 7.0 MT6750T Octa Core 1.5GHz Front Fingerprint 4G LTE Smartphone-Gold\",\n" +
            "        \"brand\": \"LEAGOO\",\n" +
            "        \"max_saving_percentage\": 23,\n" +
            "        \"price\": 50000,\n" +
            "        \"special_price\": 45990,\n" +
            "        \"image\": \"https://cdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-nexus-new.jpg\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}"

    val product: ProductResponse =
        Gson().fromJson(productDetails, ProductResponse::class.java)

}