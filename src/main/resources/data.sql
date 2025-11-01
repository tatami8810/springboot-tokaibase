/* campテーブル */
INSERT IGNORE INTO camp (id, camp_name, score, image_name, introduction, prefecture, city_address, phone_number, regular_holiday, parking, parking_fee, drive_in, check_in_time, check_out_time)  VALUES 
(1, 'KASUGAI BASE', 4, 'camp01.jpg', '松河戸インターから車で約20分、JR中央線定光寺駅から徒歩10分☆庄内川を眺めることのできる、春日井市玉野町にある広大なファミリー向けのオートキャンプ場です', '愛知', '春日井市玉野町1-2', '090-1234-5678', '火曜日', '21台', '無料', '乗用車', '14:00～19:00', '10:00');

/* facilityテーブル */
INSERT IGNORE INTO facility (id, facility_name) VALUES
(1, 'オートサイト');

/* camp_facilityテーブル */
INSERT IGNORE INTO camp_facility (camp_id, facility_id) VALUES
(1, 1);

/* shelterテーブル */
INSERT IGNORE INTO shelter
(id, shelter_name, image_name, prefecture, city_address, phone_number, capacity_short, capacity_long, space, quake, damage, safety_precautions)
VALUES
(1, '味美小学校', 'shelter01.jpg', '愛知', '春日井市味美町1-1-3', '0568-82-1234', 1130, 750, 2250, TRUE, TRUE, '水防法上の浸水想定区域内');

/* camp_shelterテーブル */
INSERT IGNORE INTO camp_shelter (camp_id, shelter_id) VALUES
(1, 1);

/* reviewテーブル */
INSERT IGNORE INTO review (id, camp_id, review, score) VALUES
(1, 1,'案内看板がわかりやすく迷わず向かえました。近くにコメリ、スーパー、薬局が揃っているので食材も炭も現地調達okです。', 5);

/* usersテーブル */
INSERT IGNORE INTO users 
(id, name, furigana, birthday, sex, postal_code, address, phone_number, email, password, enabled)
VALUES
(1, '東海 太郎', 'トウカイ タロウ', '2000-10-10', '男', '101-0022', '東京都千代田区神田練塀町300番地', '09012345678', 'taro.tokai@example.com', 'password', TRUE);

/* mamechisikiテーブル */
INSERT IGNORE INTO mamechisiki (id, mamechisiki) VALUES
(1, '雨対策として知られているレインコートは、汚れや寒さから身を守る効果を期待できます。\n\nもともとレインコートは、雨をしのぐためのものなので、高い防水機能を誇ります。「風を通しにくい」という特徴もありますので、着用するだけで外部から身を守ることができるのです。');
