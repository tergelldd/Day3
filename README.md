# Барааны бүртгэлийн систем
"Барааны бүртгэлийн систем" нь жижиг, дунд хэмжээний байгууллага, дэлгүүрт зориулсан барааны мэдээллийг удирдах зориулалттай. Энэ систем нь хэрэглэгчээс текст хэлбэрээр мэдээлэл авах, мөн текст хэлбэрээр мэдээлэл буцаан харуулах ажилладаг бөгөөд дараах гол үйлдлүүдийг гүйцэтгэдэг: бараа нэмэх, устгах, архивлах, бараа борлуулах, нөөц харах, санхүүгийн тайлан харах хийх.
 
 Тухайн систем нь JAVA програмчлалын хэл дээр бичэгдсэн бөгөөд Архивлах функц нь барааг бүр мөсөн устгахын оронд хадгалагдсан байдлаар үлдээж, мэдээлэл алдагдахаас сэргийлдэг. Үүнд дууссан бараа, засвартай бараа, бүтээгдэхүүний хугацаа нь дууссан бараа зэрэг ордог. 

Манай бүтээгдэхүүн Baraa, ArchivtHadgalah, HereglegchiinTses, NootsUdirdlaga, SankhuuUdirdlaga, ZasvartUdirdlaga, Ehleh гэсэн 7 class -аас бүрдэж байгаа

Үүнд: 

-Baraa
 - String ner
 - String code
 - int shirheg
 - double une
 - boolean zaswartai
 - localDate ognoo   гэсэн гишүүн өгөгдөлтэй , 
 - zasvartOruul , zasvartDuussan, shirhegNem, shirheghasah гэсэн функцуудтай
    
-ArchivtHadgalah
- List<Baraa> arhiv  гэсэн гишүүн өгөгдөлтэй,
- arhivtOruulah, archivtHadgalah, haruulah гэсэн функцуудтай
    
-HereglegchiinTses
 - noots
 - sanhuu
 - zasvar
 - arhiv
 - orolt гэсэн гишүүн өгөгдөлтэй
 - menuHarah, baraaNemeh, borluulah, zasvarOruulah, arhivtOruulah гэсэн функцуудтай

-NootsUdirdlaga
- baraanuud гэсэн гишүүн өгөгдөлтэй  
- baraaNemeh, borluulah, haruulah, baraaAwah, ustgah  функцуудтай

-SankhuuUdirdlaga 
 - orlogo
 - zarlaga гэсэн гишүүн өгөгдөлтэй 
 - orlogoNemeh, zarlagaHarah , tailan гэсэн функцуудтай
- ZasvarUdirdlaga
 - zasvartai гэсэн гишүүн өгөгдөлтэй , zasvartOruulah, zasvarDuussan, haruulah  гэсэн функцуудтай

UML diagram: 
	
	
	
	
	
	
	
	
	
	
	


