package ru.karapetiandav.googlebooksapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        String json = "{\n" +
                " \"kind\": \"books#volumes\",\n" +
                " \"totalItems\": 1926,\n" +
                " \"items\": [\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"3OSBaEvlpz8C\",\n" +
                "   \"etag\": \"q2fI1f9CmSM\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/3OSBaEvlpz8C\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"У Пресноводья дуб зеленый...\",\n" +
                "    \"authors\": [\n" +
                "     \"Далия Трускиновская\"\n" +
                "    ],\n" +
                "    \"publisher\": \"Litres\",\n" +
                "    \"publishedDate\": \"2017-01-12\",\n" +
                "    \"description\": \"«– Значит, бабушка, вот твое место, – сказал Портновский Вере Федоровне. – Ключ будешь брать на вахте, там у нас студент сидит, и ему же отдавать, он по суткам работает. А ты будешь сидеть тут, вязать, книжки читать, телек смотреть. Хоть песни пой – только не спи. Спать – нельзя, буду звонить ночью, проверять.– То есть, я убираю раздевалки, туалеты, мою пол в коридоре, а потом сажусь сюда? – уточнила Вера Федоровна.– Именно так. По времени у тебя получается вот что...»\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9785457216914\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"5457216918\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": true,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"pageCount\": 223,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"Fiction\"\n" +
                "    ],\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"0.1.1.0.preview.3\",\n" +
                "    \"panelizationSummary\": {\n" +
                "     \"containsEpubBubbles\": false,\n" +
                "     \"containsImageBubbles\": false\n" +
                "    },\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=3OSBaEvlpz8C&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=3OSBaEvlpz8C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"ru\",\n" +
                "    \"previewLink\": \"http://books.google.ru/books?id=3OSBaEvlpz8C&pg=PT35&dq=%D0%B7%D0%B5%D0%BB%D0%B5%D0%BD%D1%8B%D0%B9+%D0%B4%D1%83%D0%B1&hl=&cd=1&source=gbs_api\",\n" +
                "    \"infoLink\": \"https://play.google.com/store/books/details?id=3OSBaEvlpz8C&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-3OSBaEvlpz8C\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"RU\",\n" +
                "    \"saleability\": \"FOR_SALE\",\n" +
                "    \"isEbook\": true,\n" +
                "    \"listPrice\": {\n" +
                "     \"amount\": 29.5,\n" +
                "     \"currencyCode\": \"RUB\"\n" +
                "    },\n" +
                "    \"retailPrice\": {\n" +
                "     \"amount\": 26.55,\n" +
                "     \"currencyCode\": \"RUB\"\n" +
                "    },\n" +
                "    \"buyLink\": \"https://play.google.com/store/books/details?id=3OSBaEvlpz8C&rdid=book-3OSBaEvlpz8C&rdot=1&source=gbs_api\",\n" +
                "    \"offers\": [\n" +
                "     {\n" +
                "      \"finskyOfferType\": 1,\n" +
                "      \"listPrice\": {\n" +
                "       \"amountInMicros\": 2.95E7,\n" +
                "       \"currencyCode\": \"RUB\"\n" +
                "      },\n" +
                "      \"retailPrice\": {\n" +
                "       \"amountInMicros\": 2.655E7,\n" +
                "       \"currencyCode\": \"RUB\"\n" +
                "      }\n" +
                "     }\n" +
                "    ]\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"RU\",\n" +
                "    \"viewability\": \"PARTIAL\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": true,\n" +
                "     \"acsTokenLink\": \"http://books.google.ru/books/download/%D0%A3_%D0%9F%D1%80%D0%B5%D1%81%D0%BD%D0%BE%D0%B2%D0%BE%D0%B4%D1%8C%D1%8F_%D0%B4%D1%83%D0%B1_%D0%B7%D0%B5%D0%BB-sample-epub.acsm?id=3OSBaEvlpz8C&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": true,\n" +
                "     \"acsTokenLink\": \"http://books.google.ru/books/download/%D0%A3_%D0%9F%D1%80%D0%B5%D1%81%D0%BD%D0%BE%D0%B2%D0%BE%D0%B4%D1%8C%D1%8F_%D0%B4%D1%83%D0%B1_%D0%B7%D0%B5%D0%BB-sample-pdf.acsm?id=3OSBaEvlpz8C&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=3OSBaEvlpz8C&hl=&printsec=frontcover&output=reader&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"fH0YAQAAIAAJ\",\n" +
                "   \"etag\": \"fPgejNW8zX8\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/fH0YAQAAIAAJ\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"У лукоморья дуб зеленый --\",\n" +
                "    \"subtitle\": \"роман-хроника\",\n" +
                "    \"authors\": [\n" +
                "     \"Александр Коноплин\"\n" +
                "    ],\n" +
                "    \"publisher\": \"\",\n" +
                "    \"publishedDate\": \"2002\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"OTHER\",\n" +
                "      \"identifier\": \"STANFORD:36105114907525\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": false,\n" +
                "     \"image\": false\n" +
                "    },\n" +
                "    \"pageCount\": 237,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"preview-1.0.0\",\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=fH0YAQAAIAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=fH0YAQAAIAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"ru\",\n" +
                "    \"previewLink\": \"http://books.google.ru/books?id=fH0YAQAAIAAJ&q=%D0%B7%D0%B5%D0%BB%D0%B5%D0%BD%D1%8B%D0%B9+%D0%B4%D1%83%D0%B1&dq=%D0%B7%D0%B5%D0%BB%D0%B5%D0%BD%D1%8B%D0%B9+%D0%B4%D1%83%D0%B1&hl=&cd=2&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.ru/books?id=fH0YAQAAIAAJ&dq=%D0%B7%D0%B5%D0%BB%D0%B5%D0%BD%D1%8B%D0%B9+%D0%B4%D1%83%D0%B1&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/%D0%A3_%D0%BB%D1%83%D0%BA%D0%BE%D0%BC%D0%BE%D1%80%D1%8C%D1%8F_%D0%B4%D1%83%D0%B1_%D0%B7%D0%B5%D0%BB%D0%B5%D0%BD.html?hl=&id=fH0YAQAAIAAJ\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"RU\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"RU\",\n" +
                "    \"viewability\": \"NO_PAGES\",\n" +
                "    \"embeddable\": false,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=fH0YAQAAIAAJ&hl=&printsec=frontcover&output=reader&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"NONE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"G9BvDwEACAAJ\",\n" +
                "   \"etag\": \"gcGJnHe7mAA\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/G9BvDwEACAAJ\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"У Лукоморья дуб зеленый...\",\n" +
                "    \"subtitle\": \"[сказки : для чтения взрослыми детям]\",\n" +
                "    \"authors\": [\n" +
                "     \"Александр Сергеевич Пушкин\"\n" +
                "    ],\n" +
                "    \"publishedDate\": \"2010\",\n" +
                "    \"description\": \"С книгами этой серии ваш ребенок сделает первые шаги в мир знаний, сумеет - с нашей и вашей помощью - расширить свой кругозор\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"597810400X\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9785978104004\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": false,\n" +
                "     \"image\": false\n" +
                "    },\n" +
                "    \"pageCount\": 135,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"categories\": [\n" +
                "     \"Literary Collections\"\n" +
                "    ],\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"preview-1.0.0\",\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=G9BvDwEACAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=G9BvDwEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"ru\",\n" +
                "    \"previewLink\": \"http://books.google.ru/books?id=G9BvDwEACAAJ&dq=%D0%B7%D0%B5%D0%BB%D0%B5%D0%BD%D1%8B%D0%B9+%D0%B4%D1%83%D0%B1&hl=&cd=3&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.ru/books?id=G9BvDwEACAAJ&dq=%D0%B7%D0%B5%D0%BB%D0%B5%D0%BD%D1%8B%D0%B9+%D0%B4%D1%83%D0%B1&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/%D0%A3_%D0%9B%D1%83%D0%BA%D0%BE%D0%BC%D0%BE%D1%80%D1%8C%D1%8F_%D0%B4%D1%83%D0%B1_%D0%B7%D0%B5%D0%BB%D0%B5%D0%BD.html?hl=&id=G9BvDwEACAAJ\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"RU\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"RU\",\n" +
                "    \"viewability\": \"NO_PAGES\",\n" +
                "    \"embeddable\": false,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=G9BvDwEACAAJ&hl=&printsec=frontcover&output=reader&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"NONE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   },\n" +
                "   \"searchInfo\": {\n" +
                "    \"textSnippet\": \"С книгами этой серии ваш ребенок сделает первые шаги в мир знаний, сумеет - с нашей и вашей помощью - расширить свой кругозор\"\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"4YZgAAAAMAAJ\",\n" +
                "   \"etag\": \"4TKR83RQ010\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/4YZgAAAAMAAJ\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"Зимний дуб\",\n" +
                "    \"subtitle\": \"рассказы\",\n" +
                "    \"authors\": [\n" +
                "     \"Юрий Маркович Нагибин\"\n" +
                "    ],\n" +
                "    \"publishedDate\": \"1955\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"OTHER\",\n" +
                "      \"identifier\": \"UOM:39015033115208\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": false,\n" +
                "     \"image\": false\n" +
                "    },\n" +
                "    \"pageCount\": 318,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"0.1.1.0.preview.0\",\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=4YZgAAAAMAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=4YZgAAAAMAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"ru\",\n" +
                "    \"previewLink\": \"http://books.google.ru/books?id=4YZgAAAAMAAJ&q=%D0%B7%D0%B5%D0%BB%D0%B5%D0%BD%D1%8B%D0%B9+%D0%B4%D1%83%D0%B1&dq=%D0%B7%D0%B5%D0%BB%D0%B5%D0%BD%D1%8B%D0%B9+%D0%B4%D1%83%D0%B1&hl=&cd=4&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.ru/books?id=4YZgAAAAMAAJ&dq=%D0%B7%D0%B5%D0%BB%D0%B5%D0%BD%D1%8B%D0%B9+%D0%B4%D1%83%D0%B1&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/%D0%97%D0%B8%D0%BC%D0%BD%D0%B8%D0%B9_%D0%B4%D1%83%D0%B1.html?hl=&id=4YZgAAAAMAAJ\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"RU\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"RU\",\n" +
                "    \"viewability\": \"NO_PAGES\",\n" +
                "    \"embeddable\": false,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=4YZgAAAAMAAJ&hl=&printsec=frontcover&output=reader&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"NONE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   },\n" +
                "   \"searchInfo\": {\n" +
                "    \"textSnippet\": \"А теперь, наверное, \\u003cb\\u003eзеленый\\u003c/b\\u003e свет месяца бьет в ее старые глаза. И еще не \\u003cbr\\u003e\\nсказал он, что к зиме ей надо устроить пещерку из ватного одеяла, иначе \\u003cbr\\u003e\\nона проснется от своей зимней спячки, как это случилось в первый год ее&nbsp;...\"\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "   \"kind\": \"books#volume\",\n" +
                "   \"id\": \"3Ifd-mKKqRYC\",\n" +
                "   \"etag\": \"OyaQ2uRJHfc\",\n" +
                "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/3Ifd-mKKqRYC\",\n" +
                "   \"volumeInfo\": {\n" +
                "    \"title\": \"Школный словар крылатых выражении Пушкина\",\n" +
                "    \"publisher\": \"ОЛМА Медиа Групп\",\n" +
                "    \"publishedDate\": \"2005\",\n" +
                "    \"industryIdentifiers\": [\n" +
                "     {\n" +
                "      \"type\": \"ISBN_10\",\n" +
                "      \"identifier\": \"5765445403\"\n" +
                "     },\n" +
                "     {\n" +
                "      \"type\": \"ISBN_13\",\n" +
                "      \"identifier\": \"9785765445402\"\n" +
                "     }\n" +
                "    ],\n" +
                "    \"readingModes\": {\n" +
                "     \"text\": false,\n" +
                "     \"image\": true\n" +
                "    },\n" +
                "    \"pageCount\": 799,\n" +
                "    \"printType\": \"BOOK\",\n" +
                "    \"averageRating\": 5.0,\n" +
                "    \"ratingsCount\": 1,\n" +
                "    \"maturityRating\": \"NOT_MATURE\",\n" +
                "    \"allowAnonLogging\": false,\n" +
                "    \"contentVersion\": \"0.0.1.0.preview.1\",\n" +
                "    \"imageLinks\": {\n" +
                "     \"smallThumbnail\": \"http://books.google.com/books/content?id=3Ifd-mKKqRYC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "     \"thumbnail\": \"http://books.google.com/books/content?id=3Ifd-mKKqRYC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "    },\n" +
                "    \"language\": \"ru\",\n" +
                "    \"previewLink\": \"http://books.google.ru/books?id=3Ifd-mKKqRYC&pg=PA666&dq=%D0%B7%D0%B5%D0%BB%D0%B5%D0%BD%D1%8B%D0%B9+%D0%B4%D1%83%D0%B1&hl=&cd=5&source=gbs_api\",\n" +
                "    \"infoLink\": \"http://books.google.ru/books?id=3Ifd-mKKqRYC&dq=%D0%B7%D0%B5%D0%BB%D0%B5%D0%BD%D1%8B%D0%B9+%D0%B4%D1%83%D0%B1&hl=&source=gbs_api\",\n" +
                "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/%D0%A8%D0%BA%D0%BE%D0%BB%D0%BD%D1%8B%D0%B9_%D1%81%D0%BB%D0%BE%D0%B2%D0%B0%D1%80_%D0%BA%D1%80%D1%8B%D0%BB%D0%B0%D1%82.html?hl=&id=3Ifd-mKKqRYC\"\n" +
                "   },\n" +
                "   \"saleInfo\": {\n" +
                "    \"country\": \"RU\",\n" +
                "    \"saleability\": \"NOT_FOR_SALE\",\n" +
                "    \"isEbook\": false\n" +
                "   },\n" +
                "   \"accessInfo\": {\n" +
                "    \"country\": \"RU\",\n" +
                "    \"viewability\": \"PARTIAL\",\n" +
                "    \"embeddable\": true,\n" +
                "    \"publicDomain\": false,\n" +
                "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "    \"epub\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"pdf\": {\n" +
                "     \"isAvailable\": false\n" +
                "    },\n" +
                "    \"webReaderLink\": \"http://play.google.com/books/reader?id=3Ifd-mKKqRYC&hl=&printsec=frontcover&output=reader&source=gbs_api\",\n" +
                "    \"accessViewStatus\": \"SAMPLE\",\n" +
                "    \"quoteSharingAllowed\": false\n" +
                "   },\n" +
                "   \"searchInfo\": {\n" +
                "    \"textSnippet\": \"(С. Маршак. Мысли о словах) См. БОЛДИНСКАЯ ОСЕНЬ У ЛУКОМОРЬЯ \\u003cb\\u003eДУБ\\u003c/b\\u003e \\u003cbr\\u003e\\n\\u003cb\\u003eЗЕЛЕНЫЙ\\u003c/b\\u003e Руслан и Людмила, [Вступление (1824-1825)] У лукоморья \\u003cb\\u003eдуб\\u003c/b\\u003e \\u003cbr\\u003e\\n\\u003cb\\u003eзеленый\\u003c/b\\u003e; Златая цепь на дубе том: И днем и ночью кот ученый Все ходит по\\u003cbr\\u003e\\n&nbsp;...\"\n" +
                "   }\n" +
                "  }\n" +
                " ]\n" +
                "}\n";

        ArrayList<Book> books = BookUtils.extractBooks(json);
        ArrayAdapter<Book> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_2, books);
        listView.setAdapter(adapter);
    }
}
