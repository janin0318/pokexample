package jp.co.pokexample.converter;

import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VersionConverter {

  private static final Map<String, String> conversionMap = new HashMap<>() {
    {
      put("red", "赤(第一世代)");
      // PokeAPIはUS版準拠のため青は緑となる
      put("blue", "緑(第一世代)");
      put("yellow", "ピカチュウ(第一世代)");
      put("gold", "金(第二世代)");
      put("silver", "銀(第二世代)");
      put("crystal", "クリスタル(第二世代)");
      put("ruby", "ルビー(第三世代)");
      put("sapphire", "サファイア(第三世代)");
      put("firered", "ファイアレッド(第三世代)");
      put("leafgreen", "リーフグリーン(第三世代)");
      put("emerald", "エメラルド(第三世代)");
      put("diamond", "ダイヤモンド(第四世代)");
      put("pearl", "パール(第四世代)");
      put("platinum", "プラチナ(第四世代)");
      put("heartgold", "ハートゴールド(第四世代)");
      put("soulsilver", "ソウルシルバー(第四世代)");
      put("black", "ブラック(第五世代)");
      put("white", "ホワイト(第五世代)");
      put("black-2", "ブラック2(第五世代)");
      put("white-2", "ホワイト2(第五世代)");
      put("x", "X(第六世代)");
      put("y", "Y(第六世代)");
      put("omega-ruby", "オメガルビー(第六世代)");
      put("alpha-sapphire", "アルファサファイア(第六世代)");
      put("sun", "サン(第七世代)");
      put("moon", "ムーン(第七世代)");
      put("ultra-sun", "ウルトラサン(第七世代)");
      put("ultra-moon", "ウルトラムーン(第七世代)");
      put("lets-go-pikachu", "Let’s Go! ピカチュウ(第七世代)");
      put("lets-go-eevee", "Let’s Go! イーブイ(第七世代)");
      put("sword", "ソード(第八世代)");
      put("shield", "シールド(第八世代)");
      put("brilliant-diamond", "ブリリアントダイヤモンド(第八世代)");
      put("shining-pearl", "シャイニングパール(第八世代)");
      put("arceus", "Pokémon LEGENDS アルセウス(第八世代)");
      put("scarlet", "スカーレット(第九世代)");
      put("violet", "ヴァイオレット(第九世代)");
    }
  };

  /**
   * PokeApiの
   * @param version
   * @return
   */
  public static String convertVersion(String version) {
    return conversionMap.getOrDefault(version, version);
  }

}
