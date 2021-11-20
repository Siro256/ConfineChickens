# ConfineChickens
![Build status](https://github.com/Siro256/ConfineChickens/actions/workflows/build.yml/badge.svg)
![Latest version](https://img.shields.io/badge/Latest-0.1.0--SNAPSHOT-blue "Latest")<br>
「世の鶏よ、働け」
## Overview
ワールド上の鶏の当たり判定を削除することにより、<br>
サーバー/クライアントの演算を減らし軽量化します。

### 導入していない場合
![Vanilla/Client](https://media.discordapp.net/attachments/299822025067855883/911628222012215306/unknown.png "Vanilla/Client")
![Vanilla/Server](https://media.discordapp.net/attachments/299822025067855883/911636873556947004/unknown.png "Vanilla/Server")

### 導入した場合
![ConfineChickens](https://media.discordapp.net/attachments/299822025067855883/911630185466560592/unknown.png "ConfineChickens/Client")
![ConfineChickens/Server](https://media.discordapp.net/attachments/299822025067855883/911638987112869958/unknown.png "ConfineChickens/Server")

## ビルド方法
1. `git clone https://github.com/Siro256/ConfineChickens`
2. `./gradlew build` or `gradlew.bat build`
3. Move jar in `build/libs/ConfineChickens-@VERSION@.jar` to your server `plugins/` directory.

## License
このプラグインはGPLv3で頒布されています。
