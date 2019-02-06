package tcgwars.logic.impl.gen7;

import static tcgwars.logic.card.HP.*;
import static tcgwars.logic.card.Type.*;
import static tcgwars.logic.card.CardType.*;
import static tcgwars.logic.groovy.TcgBuilders.*;
import static tcgwars.logic.groovy.TcgStatics.*
import static tcgwars.logic.effect.ability.Ability.ActivationReason.*
import static tcgwars.logic.effect.EffectType.*;
import static tcgwars.logic.effect.Source.*;
import static tcgwars.logic.effect.EffectPriority.*
import static tcgwars.logic.effect.special.SpecialConditionType.*
import static tcgwars.logic.card.Resistance.ResistanceType.*

import java.util.*;
import org.apache.commons.lang.WordUtils;
import tcgwars.entity.*;
import tcgwars.logic.*;
import tcgwars.logic.card.*;
import tcgwars.logic.card.energy.*;
import tcgwars.logic.card.pokemon.*;
import tcgwars.logic.card.trainer.*;
import tcgwars.logic.effect.*;
import tcgwars.logic.effect.ability.*;
import tcgwars.logic.effect.ability.Ability.*;
import tcgwars.logic.effect.advanced.*;
import tcgwars.logic.effect.basic.*;
import tcgwars.logic.effect.blocking.*;
import tcgwars.logic.effect.event.*;
import tcgwars.logic.effect.getter.*;
import tcgwars.logic.effect.special.*;
import tcgwars.logic.util.*;

public enum TeamUp implements CardInfo {
    CELEBI_VENUSAUR_GX_1("Celebi & Venusaur-GX", 1, Rarity.ULTRARARE, [TAG_TEAM,POKEMON_GX,POKEMON,_GRASS_,BASIC]),
    WEEDLE_2("Weedle", 2, Rarity.COMMON, [POKEMON,_GRASS_,BASIC]),
    WEEDLE_3("Weedle", 3, Rarity.COMMON, [POKEMON,_GRASS_,BASIC]),
    KAKUNA_4("Kakuna", 4, Rarity.UNCOMMON, [POKEMON,_GRASS_,STAGE1,EVOLUTION]),
    BEEDRILL_5("Beedrill", 5, Rarity.RARE, [POKEMON,_GRASS_,STAGE2,EVOLUTION]),
    PARAS_6("Paras", 6, Rarity.COMMON, [POKEMON,_GRASS_,BASIC]),
    PARASECT_7("Parasect", 7, Rarity.RARE, [POKEMON,_GRASS_,STAGE1,EVOLUTION]),
    EXEGGCUTE_8("Exeggcute", 8, Rarity.COMMON, [POKEMON,_GRASS_,BASIC]),
    PINSIR_9("Pinsir", 9, Rarity.RARE, [POKEMON,_GRASS_,BASIC]),
    SHAYMIN_PRISM_STAR_10("Shaymin Prism Star", 10, Rarity.HOLORARE, [PRISM_STAR,POKEMON,_GRASS_,BASIC]),
    CHARMANDER_11("Charmander", 11, Rarity.COMMON, [POKEMON,_FIRE_,BASIC]),
    CHARMANDER_12("Charmander", 12, Rarity.COMMON, [POKEMON,_FIRE_,BASIC]),
    CHARMELEON_13("Charmeleon", 13, Rarity.UNCOMMON, [POKEMON,_FIRE_,STAGE1,EVOLUTION]),
    CHARIZARD_14("Charizard", 14, Rarity.RARE, [POKEMON,_FIRE_,STAGE2,EVOLUTION]),
    VULPIX_15("Vulpix", 15, Rarity.COMMON, [POKEMON,_FIRE_,BASIC]),
    NINETALES_16("Ninetales", 16, Rarity.RARE, [POKEMON,_FIRE_,STAGE1,EVOLUTION]),
    PONYTA_17("Ponyta", 17, Rarity.COMMON, [POKEMON,_FIRE_,BASIC]),
    RAPIDASH_18("Rapidash", 18, Rarity.UNCOMMON, [POKEMON,_FIRE_,STAGE1,EVOLUTION]),
    MOLTRES_19("Moltres", 19, Rarity.HOLORARE, [POKEMON,_FIRE_,BASIC]),
    LITTEN_20("Litten", 20, Rarity.COMMON, [POKEMON,_FIRE_,BASIC]),
    TORRACAT_21("Torracat", 21, Rarity.UNCOMMON, [POKEMON,_FIRE_,STAGE1,EVOLUTION]),
    SQUIRTLE_22("Squirtle", 22, Rarity.COMMON, [POKEMON,_WATER_,BASIC]),
    SQUIRTLE_23("Squirtle", 23, Rarity.COMMON, [POKEMON,_WATER_,BASIC]),
    WARTORTLE_24("Wartortle", 24, Rarity.UNCOMMON, [POKEMON,_WATER_,STAGE1,EVOLUTION]),
    BLASTOISE_25("Blastoise", 25, Rarity.RARE, [POKEMON,_WATER_,STAGE2,EVOLUTION]),
    PSYDUCK_26("Psyduck", 26, Rarity.COMMON, [POKEMON,_WATER_,BASIC]),
    GOLDUCK_27("Golduck", 27, Rarity.UNCOMMON, [POKEMON,_WATER_,STAGE1,EVOLUTION]),
    STARYU_28("Staryu", 28, Rarity.COMMON, [POKEMON,_WATER_,BASIC]),
    MAGIKARP_29("Magikarp", 29, Rarity.COMMON, [POKEMON,_WATER_,BASIC]),
    LAPRAS_30("Lapras", 30, Rarity.RARE, [POKEMON,_WATER_,BASIC]),
    ARTICUNO_31("Articuno", 31, Rarity.HOLORARE, [POKEMON,_WATER_,BASIC]),
    PIKACHU_ZEKROM_GX_32("Pikachu & Zekrom-GX", 32, Rarity.ULTRARARE, [TAG_TEAM,POKEMON_GX,POKEMON,_LIGHTNING_,BASIC]),
    ALOLAN_GEODUDE_33("Alolan Geodude", 33, Rarity.COMMON, [POKEMON,_LIGHTNING_,BASIC]),
    ALOLAN_GEODUDE_34("Alolan Geodude", 34, Rarity.COMMON, [POKEMON,_LIGHTNING_,BASIC]),
    ALOLAN_GRAVELER_35("Alolan Graveler", 35, Rarity.UNCOMMON, [POKEMON,_LIGHTNING_,STAGE1,EVOLUTION]),
    ALOLAN_GOLEM_36("Alolan Golem", 36, Rarity.RARE, [POKEMON,_LIGHTNING_,STAGE2,EVOLUTION]),
    VOLTORB_37("Voltorb", 37, Rarity.COMMON, [POKEMON,_LIGHTNING_,BASIC]),
    ELECTRODE_38("Electrode", 38, Rarity.HOLORARE, [POKEMON,_LIGHTNING_,STAGE1,EVOLUTION]),
    ZAPDOS_39("Zapdos", 39, Rarity.HOLORARE, [POKEMON,_LIGHTNING_,BASIC]),
    MAREEP_40("Mareep", 40, Rarity.COMMON, [POKEMON,_LIGHTNING_,BASIC]),
    FLAAFFY_41("Flaaffy", 41, Rarity.UNCOMMON, [POKEMON,_LIGHTNING_,STAGE1,EVOLUTION]),
    AMPHAROS_GX_42("Ampharos-GX", 42, Rarity.ULTRARARE, [POKEMON_GX,POKEMON,_LIGHTNING_,STAGE2,EVOLUTION]),
    BLITZLE_43("Blitzle", 43, Rarity.COMMON, [POKEMON,_LIGHTNING_,BASIC]),
    ZEBSTRIKA_44("Zebstrika", 44, Rarity.RARE, [POKEMON,_LIGHTNING_,STAGE1,EVOLUTION]),
    EMOLGA_45("Emolga", 45, Rarity.COMMON, [POKEMON,_LIGHTNING_,BASIC]),
    JOLTIK_46("Joltik", 46, Rarity.COMMON, [POKEMON,_LIGHTNING_,BASIC]),
    GALVANTULA_47("Galvantula", 47, Rarity.RARE, [POKEMON,_LIGHTNING_,STAGE1,EVOLUTION]),
    HELIOPTILE_48("Helioptile", 48, Rarity.COMMON, [POKEMON,_LIGHTNING_,BASIC]),
    HELIOLISK_49("Heliolisk", 49, Rarity.UNCOMMON, [POKEMON,_LIGHTNING_,STAGE1,EVOLUTION]),
    TAPU_KOKO_PRISM_STAR_50("Tapu Koko Prism Star", 50, Rarity.HOLORARE, [PRISM_STAR,POKEMON,_LIGHTNING_,BASIC]),
    ZERAORA_51("Zeraora", 51, Rarity.HOLORARE, [POKEMON,_LIGHTNING_,BASIC]),
    GENGAR_MIMIKYU_GX_52("Gengar & Mimikyu-GX", 52, Rarity.ULTRARARE, [TAG_TEAM,POKEMON_GX,POKEMON,_PSYCHIC_,BASIC]),
    NIDORAN_FEMALE_53("Nidoran Female", 53, Rarity.COMMON, [POKEMON,_PSYCHIC_,BASIC]),
    NIDORINA_54("Nidorina", 54, Rarity.UNCOMMON, [POKEMON,_PSYCHIC_,STAGE1,EVOLUTION]),
    NIDOQUEEN_55("Nidoqueen", 55, Rarity.RARE, [POKEMON,_PSYCHIC_,STAGE2,EVOLUTION]),
    NIDORAN_MALE_56("Nidoran Male", 56, Rarity.COMMON, [POKEMON,_PSYCHIC_,BASIC]),
    NIDORINO_57("Nidorino", 57, Rarity.UNCOMMON, [POKEMON,_PSYCHIC_,STAGE1,EVOLUTION]),
    NIDOKING_58("Nidoking", 58, Rarity.RARE, [POKEMON,_PSYCHIC_,STAGE2,EVOLUTION]),
    TENTACOOL_59("Tentacool", 59, Rarity.COMMON, [POKEMON,_PSYCHIC_,BASIC]),
    TENTACRUEL_60("Tentacruel", 60, Rarity.UNCOMMON, [POKEMON,_PSYCHIC_,STAGE1,EVOLUTION]),
    GRIMER_61("Grimer", 61, Rarity.COMMON, [POKEMON,_PSYCHIC_,BASIC]),
    MUK_62("Muk", 62, Rarity.RARE, [POKEMON,_PSYCHIC_,STAGE1,EVOLUTION]),
    ALOLAN_MAROWAK_63("Alolan Marowak", 63, Rarity.RARE, [POKEMON,_PSYCHIC_,STAGE1,EVOLUTION]),
    STARMIE_64("Starmie", 64, Rarity.RARE, [POKEMON,_PSYCHIC_,STAGE1,EVOLUTION]),
    MR_MIME_65("Mr. Mime", 65, Rarity.RARE, [POKEMON,_PSYCHIC_,BASIC]),
    MR_MIME_GX_66("Mr. Mime-GX", 66, Rarity.ULTRARARE, [POKEMON_GX,POKEMON,_PSYCHIC_,BASIC]),
    JYNX_67("Jynx", 67, Rarity.UNCOMMON, [POKEMON,_PSYCHIC_,BASIC]),
    COSMOG_68("Cosmog", 68, Rarity.COMMON, [POKEMON,_PSYCHIC_,BASIC]),
    COSMOEM_69("Cosmoem", 69, Rarity.UNCOMMON, [POKEMON,_PSYCHIC_,STAGE1,EVOLUTION]),
    MANKEY_70("Mankey", 70, Rarity.COMMON, [POKEMON,_FIGHTING_,BASIC]),
    PRIMEAPE_71("Primeape", 71, Rarity.RARE, [POKEMON,_FIGHTING_,STAGE1,EVOLUTION]),
    HITMONLEE_72("Hitmonlee", 72, Rarity.UNCOMMON, [POKEMON,_FIGHTING_,BASIC]),
    HITMONCHAN_73("Hitmonchan", 73, Rarity.UNCOMMON, [POKEMON,_FIGHTING_,BASIC]),
    OMANYTE_74("Omanyte", 74, Rarity.UNCOMMON, [POKEMON,_FIGHTING_,STAGE1,EVOLUTION]),
    OMASTAR_75("Omastar", 75, Rarity.HOLORARE, [POKEMON,_FIGHTING_,STAGE2,EVOLUTION]),
    KABUTO_76("Kabuto", 76, Rarity.UNCOMMON, [POKEMON,_FIGHTING_,STAGE1,EVOLUTION]),
    KABUTOPS_77("Kabutops", 77, Rarity.RARE, [POKEMON,_FIGHTING_,STAGE2,EVOLUTION]),
    LARVITAR_78("Larvitar", 78, Rarity.COMMON, [POKEMON,_FIGHTING_,BASIC]),
    PUPITAR_79("Pupitar", 79, Rarity.UNCOMMON, [POKEMON,_FIGHTING_,STAGE1,EVOLUTION]),
    PANCHAM_80("Pancham", 80, Rarity.COMMON, [POKEMON,_FIGHTING_,BASIC]),
    LYCANROC_GX_81("Lycanroc-GX", 81, Rarity.ULTRARARE, [POKEMON_GX,POKEMON,_FIGHTING_,STAGE1,EVOLUTION]),
    ALOLAN_GRIMER_82("Alolan Grimer", 82, Rarity.COMMON, [POKEMON,_DARKNESS_,BASIC]),
    ALOLAN_MUK_83("Alolan Muk", 83, Rarity.RARE, [POKEMON,_DARKNESS_,STAGE1,EVOLUTION]),
    TYRANITAR_84("Tyranitar", 84, Rarity.HOLORARE, [POKEMON,_DARKNESS_,STAGE2,EVOLUTION]),
    POOCHYENA_85("Poochyena", 85, Rarity.COMMON, [POKEMON,_DARKNESS_,BASIC]),
    MIGHTYENA_86("Mightyena", 86, Rarity.RARE, [POKEMON,_DARKNESS_,STAGE1,EVOLUTION]),
    ABSOL_87("Absol", 87, Rarity.HOLORARE, [POKEMON,_DARKNESS_,BASIC]),
    SPIRITOMB_88("Spiritomb", 88, Rarity.UNCOMMON, [POKEMON,_DARKNESS_,BASIC]),
    ZORUA_89("Zorua", 89, Rarity.COMMON, [POKEMON,_DARKNESS_,BASIC]),
    ZOROARK_90("Zoroark", 90, Rarity.HOLORARE, [POKEMON,_DARKNESS_,STAGE1,EVOLUTION]),
    VULLABY_91("Vullaby", 91, Rarity.COMMON, [POKEMON,_DARKNESS_,BASIC]),
    MANDIBUZZ_92("Mandibuzz", 92, Rarity.RARE, [POKEMON,_DARKNESS_,STAGE1,EVOLUTION]),
    PANGORO_93("Pangoro", 93, Rarity.RARE, [POKEMON,_DARKNESS_,STAGE1,EVOLUTION]),
    YVELTAL_94("Yveltal", 94, Rarity.HOLORARE, [POKEMON,_DARKNESS_,BASIC]),
    HOOPA_GX_95("Hoopa-GX", 95, Rarity.ULTRARARE, [POKEMON_GX,POKEMON,_DARKNESS_,BASIC]),
    INCINEROAR_GX_96("Incineroar-GX", 96, Rarity.ULTRARARE, [POKEMON_GX,POKEMON,_DARKNESS_,STAGE2,EVOLUTION]),
    SKARMORY_97("Skarmory", 97, Rarity.RARE, [POKEMON,_METAL_,BASIC]),
    JIRACHI_98("Jirachi", 98, Rarity.HOLORARE, [POKEMON,_METAL_,BASIC]),
    BRONZOR_99("Bronzor", 99, Rarity.COMMON, [POKEMON,_METAL_,BASIC]),
    BRONZONG_100("Bronzong", 100, Rarity.RARE, [POKEMON,_METAL_,STAGE1,EVOLUTION]),
    FERROSEED_101("Ferroseed", 101, Rarity.COMMON, [POKEMON,_METAL_,BASIC]),
    FERROTHORN_102("Ferrothorn", 102, Rarity.RARE, [POKEMON,_METAL_,STAGE1,EVOLUTION]),
    PAWNIARD_103("Pawniard", 103, Rarity.COMMON, [POKEMON,_METAL_,BASIC]),
    BISHARP_104("Bisharp", 104, Rarity.RARE, [POKEMON,_METAL_,STAGE1,EVOLUTION]),
    COBALION_GX_105("Cobalion-GX", 105, Rarity.ULTRARARE, [POKEMON_GX,POKEMON,_METAL_,BASIC]),
    HONEDGE_106("Honedge", 106, Rarity.COMMON, [POKEMON,_METAL_,BASIC]),
    DOUBLADE_107("Doublade", 107, Rarity.UNCOMMON, [POKEMON,_METAL_,STAGE1,EVOLUTION]),
    AEGISLASH_108("Aegislash", 108, Rarity.HOLORARE, [POKEMON,_METAL_,STAGE2,EVOLUTION]),
    KLEFKI_109("Klefki", 109, Rarity.COMMON, [POKEMON,_METAL_,BASIC]),
    ALOLAN_NINETALES_110("Alolan Ninetales", 110, Rarity.HOLORARE, [POKEMON,_FAIRY_,STAGE1,EVOLUTION]),
    MIMIKYU_111("Mimikyu", 111, Rarity.RARE, [POKEMON,_FAIRY_,BASIC]),
    LATIAS_LATIOS_GX_112("Latias & Latios-GX", 112, Rarity.ULTRARARE, [TAG_TEAM,POKEMON_GX,POKEMON,_DRAGON_,BASIC]),
    ALOLAN_EXEGGUTOR_113("Alolan Exeggutor", 113, Rarity.RARE, [POKEMON,_DRAGON_,STAGE1,EVOLUTION]),
    ALOLAN_EXEGGUTOR_114("Alolan Exeggutor", 114, Rarity.RARE, [POKEMON,_DRAGON_,STAGE1,EVOLUTION]),
    DRATINI_115("Dratini", 115, Rarity.COMMON, [POKEMON,_DRAGON_,BASIC]),
    DRATINI_116("Dratini", 116, Rarity.COMMON, [POKEMON,_DRAGON_,BASIC]),
    DRAGONAIR_117("Dragonair", 117, Rarity.UNCOMMON, [POKEMON,_DRAGON_,STAGE1,EVOLUTION]),
    DRAGONITE_118("Dragonite", 118, Rarity.HOLORARE, [POKEMON,_DRAGON_,STAGE2,EVOLUTION]),
    EEVEE_SNORLAX_GX_119("Eevee & Snorlax-GX", 119, Rarity.ULTRARARE, [TAG_TEAM,POKEMON_GX,POKEMON,_COLORLESS_,BASIC]),
    PIDGEY_120("Pidgey", 120, Rarity.COMMON, [POKEMON,_COLORLESS_,BASIC]),
    PIDGEY_121("Pidgey", 121, Rarity.COMMON, [POKEMON,_COLORLESS_,BASIC]),
    PIDGEOTTO_122("Pidgeotto", 122, Rarity.COMMON, [POKEMON,_COLORLESS_,STAGE1,EVOLUTION]),
    PIDGEOT_123("Pidgeot", 123, Rarity.RARE, [POKEMON,_COLORLESS_,STAGE2,EVOLUTION]),
    MEOWTH_124("Meowth", 124, Rarity.COMMON, [POKEMON,_COLORLESS_,BASIC]),
    PERSIAN_125("Persian", 125, Rarity.UNCOMMON, [POKEMON,_COLORLESS_,STAGE1,EVOLUTION]),
    FARFETCHD_126("Farfetch'd", 126, Rarity.UNCOMMON, [POKEMON,_COLORLESS_,BASIC]),
    KANGASKHAN_127("Kangaskhan", 127, Rarity.UNCOMMON, [POKEMON,_COLORLESS_,BASIC]),
    TAUROS_128("Tauros", 128, Rarity.UNCOMMON, [POKEMON,_COLORLESS_,BASIC]),
    AERODACTYL_129("Aerodactyl", 129, Rarity.RARE, [POKEMON,_COLORLESS_,STAGE1,EVOLUTION]),
    LUGIA_130("Lugia", 130, Rarity.HOLORARE, [POKEMON,_COLORLESS_,BASIC]),
    ZANGOOSE_131("Zangoose", 131, Rarity.HOLORARE, [POKEMON,_COLORLESS_,BASIC]),
    BILLS_ANALYSIS_132("Bill's Analysis", 132, Rarity.HOLORARE, [TRAINER,SUPPORTER]),
    BLACK_MARKET_PRISM_STAR_133("Black Market Prism Star", 133, Rarity.HOLORARE, [PRISM_STAR,TRAINER,STADIUM]),
    BROCKS_GRIT_134("Brock's Grit", 134, Rarity.UNCOMMON, [TRAINER,SUPPORTER]),
    BUFF_PADDING_135("Buff Padding", 135, Rarity.UNCOMMON, [TRAINER,ITEM,POKEMON_TOOL]),
    DANA_136("Dana", 136, Rarity.UNCOMMON, [TRAINER,SUPPORTER]),
    DANGEROUS_DRILL_137("Dangerous Drill", 137, Rarity.UNCOMMON, [TRAINER,ITEM]),
    ELECTROCHARGER_138("Electrocharger", 138, Rarity.UNCOMMON, [TRAINER,ITEM]),
    ERIKAS_HOSPITALITY_139("Erika's Hospitality", 139, Rarity.HOLORARE, [TRAINER,SUPPORTER]),
    EVELYN_140("Evelyn", 140, Rarity.UNCOMMON, [TRAINER,SUPPORTER]),
    FAIRY_CHARM_UB_141("Fairy Charm UB", 141, Rarity.UNCOMMON, [TRAINER,ITEM,POKEMON_TOOL]),
    GRASS_MEMORY_142("Grass Memory", 142, Rarity.UNCOMMON, [TRAINER,ITEM,POKEMON_TOOL]),
    INGO_EMMET_143("Ingo & Emmet", 143, Rarity.UNCOMMON, [TRAINER,SUPPORTER]),
    JASMINE_144("Jasmine", 144, Rarity.UNCOMMON, [TRAINER,SUPPORTER]),
    JUDGE_WHISTLE_145("Judge Whistle", 145, Rarity.UNCOMMON, [TRAINER,ITEM]),
    LAVENDER_TOWN_146("Lavender Town", 146, Rarity.UNCOMMON, [TRAINER,STADIUM]),
    METAL_GOGGLES_147("Metal Goggles", 147, Rarity.UNCOMMON, [TRAINER,ITEM,POKEMON_TOOL]),
    MORGAN_148("Morgan", 148, Rarity.UNCOMMON, [TRAINER,SUPPORTER]),
    NANU_149("Nanu", 149, Rarity.UNCOMMON, [TRAINER,SUPPORTER]),
    NITA_150("Nita", 150, Rarity.UNCOMMON, [TRAINER,SUPPORTER]),
    POKéMON_COMMUNICATION_151("Pokémon Communication", 151, Rarity.UNCOMMON, [TRAINER,ITEM]),
    RETURN_LABEL_152("Return Label", 152, Rarity.UNCOMMON, [TRAINER,ITEM]),
    SABRINAS_SUGGESTION_153("Sabrina's Suggestion", 153, Rarity.UNCOMMON, [TRAINER,SUPPORTER]),
    UNIDENTIFIED_FOSSIL_154("Unidentified Fossil", 154, Rarity.UNCOMMON, [TRAINER,ITEM]),
    VIRIDIAN_FOREST_155("Viridian Forest", 155, Rarity.UNCOMMON, [TRAINER,STADIUM]),
    WATER_MEMORY_156("Water Memory", 156, Rarity.UNCOMMON, [TRAINER,ITEM,POKEMON_TOOL]),
    WONDROUS_LABYRINTH_PRISM_STAR_157("Wondrous Labyrinth Prism Star", 157, Rarity.HOLORARE, [PRISM_STAR,TRAINER,STADIUM]),
    CELEBI_VENUSAUR_GX_158("Celebi & Venusaur-GX", 158, Rarity.ULTRARARE, [TAG_TEAM,POKEMON_GX,POKEMON,_GRASS_,BASIC]),
    MAGIKARP_WAILORD_GX_159("Magikarp & Wailord-GX", 159, Rarity.ULTRARARE, [TAG_TEAM,POKEMON_GX,POKEMON,_WATER_,BASIC]),
    MAGIKARP_WAILORD_GX_160("Magikarp & Wailord-GX", 160, Rarity.ULTRARARE, [TAG_TEAM,POKEMON_GX,POKEMON,_WATER_,BASIC]),
    PIKACHU_ZEKROM_GX_161("Pikachu & Zekrom-GX", 161, Rarity.ULTRARARE, [TAG_TEAM,POKEMON_GX,POKEMON,_LIGHTNING_,BASIC]),
    AMPHAROS_GX_162("Ampharos-GX", 162, Rarity.ULTRARARE, [POKEMON_GX,POKEMON,_LIGHTNING_,STAGE2,EVOLUTION]),
    GENGAR_MIMIKYU_GX_163("Gengar & Mimikyu-GX", 163, Rarity.ULTRARARE, [TAG_TEAM,POKEMON_GX,POKEMON,_PSYCHIC_,BASIC]),
    GENGAR_MIMIKYU_GX_164("Gengar & Mimikyu-GX", 164, Rarity.ULTRARARE, [TAG_TEAM,POKEMON_GX,POKEMON,_PSYCHIC_,BASIC]),
    HOOPA_GX_165("Hoopa-GX", 165, Rarity.ULTRARARE, [POKEMON_GX,POKEMON,_DARKNESS_,BASIC]),
    INCINEROAR_GX_166("Incineroar-GX", 166, Rarity.ULTRARARE, [POKEMON_GX,POKEMON,_DARKNESS_,STAGE2,EVOLUTION]),
    COBALION_GX_167("Cobalion-GX", 167, Rarity.ULTRARARE, [POKEMON_GX,POKEMON,_METAL_,BASIC]),
    LATIAS_LATIOS_GX_168("Latias & Latios-GX", 168, Rarity.ULTRARARE, [TAG_TEAM,POKEMON_GX,POKEMON,_DRAGON_,BASIC]),
    LATIAS_LATIOS_GX_169("Latias & Latios-GX", 169, Rarity.ULTRARARE, [TAG_TEAM,POKEMON_GX,POKEMON,_DRAGON_,BASIC]),
    EEVEE_SNORLAX_GX_170("Eevee & Snorlax-GX", 170, Rarity.ULTRARARE, [TAG_TEAM,POKEMON_GX,POKEMON,_COLORLESS_,BASIC]),
    BROCKS_GRIT_171("Brock's Grit", 171, Rarity.ULTRARARE, [TRAINER,SUPPORTER]),
    DANA_172("Dana", 172, Rarity.ULTRARARE, [TRAINER,SUPPORTER]),
    ERIKAS_HOSPITALITY_173("Erika's Hospitality", 173, Rarity.ULTRARARE, [TRAINER,SUPPORTER]),
    EVELYN_174("Evelyn", 174, Rarity.ULTRARARE, [TRAINER,SUPPORTER]),
    INGO_EMMET_175("Ingo & Emmet", 175, Rarity.ULTRARARE, [TRAINER,SUPPORTER]),
    JASMINE_176("Jasmine", 176, Rarity.ULTRARARE, [TRAINER,SUPPORTER]),
    MORGAN_177("Morgan", 177, Rarity.ULTRARARE, [TRAINER,SUPPORTER]),
    NANU_178("Nanu", 178, Rarity.ULTRARARE, [TRAINER,SUPPORTER]),
    NITA_179("Nita", 179, Rarity.ULTRARARE, [TRAINER,SUPPORTER]),
    SABRINAS_SUGGESTION_180("Sabrina's Suggestion", 180, Rarity.ULTRARARE, [TRAINER,SUPPORTER]),
    CELEBI_VENUSAUR_GX_181("Celebi & Venusaur-GX", 181, Rarity.SECRET, [TAG_TEAM,POKEMON_GX,POKEMON,_GRASS_,BASIC]),
    MAGIKARP_WAILORD_GX_182("Magikarp & Wailord-GX", 182, Rarity.SECRET, [TAG_TEAM,POKEMON_GX,POKEMON,_WATER_,BASIC]),
    PIKACHU_ZEKROM_GX_183("Pikachu & Zekrom-GX", 183, Rarity.SECRET, [TAG_TEAM,POKEMON_GX,POKEMON,_LIGHTNING_,BASIC]),
    AMPHAROS_GX_184("Ampharos-GX", 184, Rarity.SECRET, [POKEMON_GX,POKEMON,_LIGHTNING_,STAGE2,EVOLUTION]),
    GENGAR_MIMIKYU_GX_185("Gengar & Mimikyu-GX", 185, Rarity.SECRET, [TAG_TEAM,POKEMON_GX,POKEMON,_PSYCHIC_,BASIC]),
    HOOPA_GX_186("Hoopa-GX", 186, Rarity.SECRET, [POKEMON_GX,POKEMON,_DARKNESS_,BASIC]),
    INCINEROAR_GX_187("Incineroar-GX", 187, Rarity.SECRET, [POKEMON_GX,POKEMON,_DARKNESS_,STAGE2,EVOLUTION]),
    COBALION_GX_188("Cobalion-GX", 188, Rarity.SECRET, [POKEMON_GX,POKEMON,_METAL_,BASIC]),
    LATIAS_LATIOS_GX_189("Latias & Latios-GX", 189, Rarity.SECRET, [TAG_TEAM,POKEMON_GX,POKEMON,_DRAGON_,BASIC]),
    EEVEE_SNORLAX_GX_190("Eevee & Snorlax-GX", 190, Rarity.SECRET, [TAG_TEAM,POKEMON_GX,POKEMON,_COLORLESS_,BASIC]),
    DANGEROUS_DRILL_191("Dangerous Drill", 191, Rarity.SECRET, [TRAINER,ITEM]),
    ELECTROCHARGER_192("Electrocharger", 192, Rarity.SECRET, [TRAINER,ITEM]),
    JUDGE_WHISTLE_193("Judge Whistle", 193, Rarity.SECRET, [TRAINER,ITEM]),
    METAL_GOGGLES_194("Metal Goggles", 194, Rarity.SECRET, [TRAINER,ITEM,POKEMON_TOOL]),

 static Type C = COLORLESS, R = FIRE, F = FIGHTING, G = GRASS, W = WATER, P = PSYCHIC, L = LIGHTNING, M = METAL, D = DARKNESS, Y = FAIRY, N = DRAGON;

  protected CardTypeSet cardTypes;
  protected String name;
  protected Rarity rarity;
  protected int collectionLineNo;

  TeamUp(String name, int collectionLineNo, Rarity rarity, List<CardType> cardTypes) {
    this.cardTypes = new CardTypeSet(cardTypes as CardType[]);
    this.name = name;
    this.rarity = rarity;
    this.collectionLineNo = collectionLineNo;
  }

  @Override
  public CardTypeSet getCardTypes() {
    return cardTypes;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Rarity getRarity() {
    return rarity;
  }

  @Override
  public int getCollectionLineNo() {
    return collectionLineNo;
  }

  @Override
  public tcgwars.logic.card.Collection getCollection() {
    return tcgwars.logic.card.Collection.TEAM_UP;
  }

  @Override
  public String toString() {
    return String.format("%s:%s", this.name(), this.getCollection().name());
  }

    @Override
    public String getEnumName() {
        return name();
    }

  @Override
  public Card getImplementation() {
    switch (this) {

        case CELEBI_VENUSAUR_GX_1:
        return basic (this, hp:HP270, type:GRASS, retreatCost:4) {
            weakness FIRE
            move "Pollen Hazard" , {
                text "50 Your opponent's Active Pokémon is now Burned, Confused, and Poisoned."
                energyCost G,C,C
                onAttack{
                    damage 50
                    afterDamage{
                        apply BURNED
                        apply CONFUSED
                        apply POISONED
                    }
                }
            }
            move "Solar Beam" , {
                text "150 damage"
                energyCost G,G,C,C
                onAttack{
                    damage 150
                }
            }
            move "Evergreen GX" , {
                text "180 damage. Heal all damage from this Pokémon. If this Pokémon has at least 1 extra [G] Energy attached to it (in addition to this attack’s cost), shuffle all cards from your discard pile into your deck."
                energyCost G,G,C,C
                attackRequirement {
                  gxCheck()
                }
                onAttack{
                    gxPerform()
                    damage 180
                    heal self.numberOfDamageCounters*10, self
                    if(self.cards.energySufficient(thisMove.energyCost() + G)){
                        my.discard.moveTo(my.deck)
                        shuffleDeck()
                    }
                }
            }
        };
        case WEEDLE_2:
        return basic (this, hp:HP040, type:GRASS, retreatCost:1) {
            weakness FIRE
            move "Tangle Drag" , {
                text "Switch 1 of your opponent's Benched Pokémon with their Active Pokémon."
                energyCost G
                attackRequirement{
                    assert opp.bench : "There is no Pokémon on your opponent's bench"
                }
                onAttack{
                    sw opp.active, opp.bench.select("Choose the new active")
                }
            }
            move "Bug Bite" , {
                text "10 damage."
                energyCost G
                onAttack{
                    damage 10
                }
            }
        };
        case WEEDLE_3:
        return basic (this, hp:HP050, type:GRASS, retreatCost:1) {
            weakness FIRE
            move "Reckless Charge" , {
                text "20 damage. This Pokémon does 10 damage to itself."
                energyCost C
                onAttack{
                    damage 20
                    damage 10, self
                }
            }
        };
        case KAKUNA_4:
        return 	evolution (this, from:"Weedle", hp:HP080, type:GRASS, retreatCost:3) {
            weakness FIRE
            bwAbility "Grass Cushion" , {
                text "If this Pokémon has any [G] Energy attached to it, it takes 30 less damage from attacks (after applying Weakness and Resistance)."
                      delayedA {
                        before APPLY_ATTACK_DAMAGES, {
                        if(ef.attacker.owner == self.owner.opposite && self.cards.energyCount(G)) {
                            bg.dm().each{
                            if(it.to == self && it.notNoEffect && it.dmg.value) {
                                bc "Grass Cushion -30"
                                it.dmg -= hp(30)
							                  }
							               }
						            }
						        }
        			   }
			      }
            move "Bug Bite" , {
                text "20 damage."
                energyCost C,C
                onAttack{
                    damage 20
                }
            }
        };
        case BEEDRILL_5:
        return evolution (this, from:"Kakuna", hp:HP130, type:GRASS, retreatCost:1) {
            weakness FIRE
            move "Destiny Stinger" , {
                text "You can use this attack only if this Pokémon has any damage counters on it. Both Active Pokémon are Knocked Out.\n"
                energyCost G
                attackRequirement{
                    assert self.numberOfDamageCounters : "$self has no damage counter"
                }
                onAttack{
                    new Knockout(defending).run(bg)
                    new Knockout(self).run(bg)
                }
            }
            move "Reckless Charge" , {
                text "90 damage. This Pokémon does 10 damage to itself."
                energyCost C,C
                onAttack{
                    damage 90
                    damage 10,self
                }
            }
        };
        case PARAS_6:
        return basic (this, hp:HP070, type:GRASS, retreatCost:1) {
            weakness FIRE
            move "Scratch" , {
                text "10 damage."
                energyCost C
                onAttack{
                    damage 10
                }
            }
            move "Slash" , {
                text "20 damage."
                energyCost G,C
                onAttack{
                    damage 20
                }
            }
        };
        case PARASECT_7:
        return 	evolution (this, from:"Paras", hp:HP100, type:GRASS, retreatCost:2) {
            weakness FIRE
            bwAbility "Panic Spores" , {
                text "Put 2 damage counters on your opponent's Confused Pokémon between turns."
                delayedA {
                    before BETWEEN_TURNS, {
                        if(self.owner.opposite.active.isSPC(CONFUSED)){
                            damage 20, self.owner.opposite.active
                        }
					}
                }
            }
            move "Mysterious Powder" , {
                text "30 damage. Flip a coin. If heads, your opponent's Active Pokémon is now Confused."
                energyCost G,C
                onAttack{
                    damage 30
                    flipThenApplySC CONFUSED
                }
            }
        };
        case EXEGGCUTE_8:
        return basic (this, hp:HP050, type:GRASS, retreatCost:1) {
            weakness FIRE
            move "Bullet Seed" , {
                text "10× damage. Flip 4 coins. This attack does 10 damage for each heads."
                energyCost G
                onAttack{
                    flip 4, {damage 10}
                }
            }
        };
        case PINSIR_9:
        return basic (this, hp:HP120, type:GRASS, retreatCost:3) {
            weakness FIRE
            move "Grip and Squeeze" , {
                text "30 damage. The Defending Pokémon can't retreat during your opponent's next turn.\n"
                energyCost C,C
                onAttack{
                    damage 30
                    afterDamage{
                        cantRetreat(defending)
                    }
                }
            }
            move "Guillotine Hug" , {
                text "Flip 2 coins. If both of them are heads, your opponent's Active Pokémon is Knocked Out."
                energyCost G,C,C
                onAttack{
                    flip 2,{},{},[2:{
									    bc "$defending is Knocked Out.";
                                        new Knockout(defending).run(bg)
									},1:{
										bc "$thisMove has no effect."
									},0:{
										bc "$thisMove has no effect."
									}]
                }
            }
        };
        case SHAYMIN_PRISM_STAR_10:
        return basic (this, hp:HP080, type:GRASS, retreatCost:0) {
            weakness FIRE
            move "Flower Storm" , {
                text "30× This attack does 30 damage times the amount of basic Energy attached to all of your Pokémon.\n"
                energyCost G,G
                onAttack{
                    my.all.each{
                        damage 30*it.cards.energyCount()
                    }
                }
            }
        };
        case CHARMANDER_11:
        return basic (this, hp:HP050, type:FIRE, retreatCost:1) {
            weakness WATER
            move "Scratch" , {
                text "10 damage."
                energyCost R
                onAttack{
                    damage 10
                }
            }
            move "Reprisal" , {
                text "20× This attack does 20 damage for each damage counter on this Pokémon."
                energyCost C,C
                onAttack{
                    damage 20*self.numberOfDamageCounters
                }
            }
        };
        case CHARMANDER_12:
        return basic (this, hp:HP070, type:FIRE, retreatCost:1) {
            weakness WATER
            move "Ember" , {
                text "30 damage. Discard an Energy from this Pokémon."
                energyCost R
                onAttack{
                    damage 30
                    afterDamage{
                        discardSelfEnergy C
                    }
                }
            }
        };
        case CHARMELEON_13:
        return 	evolution (this, from:"Charmander", hp:HP090, type:FIRE, retreatCost:2) {
            weakness WATER
            move "Fire Fang" , {
                text "30 damage. Your opponent's Active Pokémon is now Burned."
                energyCost R,R
                onAttack{
                    damage 30
                    afterDamage{
                        apply BURNED
                    }
                }
            }
        };
        case CHARIZARD_14:
        return 	evolution (this, from:"Charmeleon", hp:HP150, type:FIRE, retreatCost:2) {
            weakness WATER
            bwAbility "Roaring Resolve" , {
                text "Once during your turn (before your attack), you may put 2 damage counters on this Pokémon. If you do, search your deck for up to 2 [R] Energy cards and attach them to this Pokémon. Then, shuffle your deck."
                actionA {
                    checkLastTurn()
                    assert my.deck : "There is no more cards in your deck"
                    powerUsed()
                    damage 20, self
                    attachEnergyFrom(type: FIRE, my.hand, self)
                    attachEnergyFrom(type: FIRE, my.hand, self)
                    shuffleDeck()
                }
            }
            move "Continuous Blaze Ball" , {
                text "30+ Discard all [R] Energy from this Pokémon. This attack does 50 more damage for each card you discarded in this way."
                energyCost R,R
                onAttack{
                    damage 30 + 50*self.cards.filterByType(ENERGY).filterByEnergyType(R).discard().size()

                }
            }
        };
        case VULPIX_15:
        return basic (this, hp:HP060, type:FIRE, retreatCost:1) {
            weakness WATER
            move "Tail Whip" , {
                text "Flip a coin. If heads, the Defending Pokémon can't attack during your opponent's next turn."
                energyCost C
                onAttack{
                    flip{
                        cantAttackNextTurn defending
                    }
                }
            }
        };
        case NINETALES_16:
        return 	evolution (this, from:"Vulpix", hp:HP100, type:FIRE, retreatCost:1) {
            weakness WATER
            bwAbility "Nine Temptations" , {
                text "Once during your turn (before your attack), you may discard 2 Fire Energy cards from your hand. If you do, switch 1 of your opponent's Benched Pokémon with their Active Pokémon."
                actionA{
                    checkLastTurn()
                    def src = my.hand.filterByType(ENERGY).filterByEnergyType(R)
                    assert src.size() >= 2 : "you don't have enough Fire Energy cards to discard"
                    powerUsed()
                    src.select(count : 2).discard()
                    sw self.owner.opposite.active, self.owner.opposite.active
                    shuffleDeck()
                }
            }
            move "Flame Tail" , {
                text "90 damage"
                energyCost R,C,C
                onAttack{
                  damage 90
                }
            }
        };
        case PONYTA_17:
        return basic (this, hp:HP070, type:FIRE, retreatCost:1) {
            weakness WATER
            move "Live Coal" , {
                text "10 damage"
                energyCost R
                onAttack{
                  damage 10
                }
            }
            move "Stomp" , {
                text "10+ damage. Flip a coin. If heads, this attack does 30 more damage."
                energyCost R,R
                onAttack{
                  damage 10
                  flip{damage 30}
                }
            }
        };
        case RAPIDASH_18:
        return 	evolution (this, from:"Ponyta", hp:HP100, type:FIRE, retreatCost:1) {
            weakness WATER
            move "Searing Flame" , {
                text "20 damage. Your opponent's Active Pokémon is now Burned.\n"
                energyCost R
                onAttack{
                  damage 20
                  apply BURNED
                }
            }
            move "Agility" , {
                text "60 damage. Flip a coin. If heads, prevent all effects of attacks, including damage, done to this Pokémon during your opponent's next turn."
                energyCost R,R
                onAttack{
                  damage 60
                  afterDamage{
                    flip{preventAllEffectsNextTurn()}
                  }
                }
            }
        };
        case MOLTRES_19:
        return basic (this, hp:HP120, type:FIRE, retreatCost:2) {
            weakness LIGHTNING
            resistance FIGHTING, MINUS20
            move "Top Burner" , {
                text "Discard all [R] Energy from this Pokémon. Then, discard a card from the top of your opponent’s deck for each Energy you discarded in this way."
                energyCost R
                attackRequirement{
                  assert opp.deck : "There is no more card in opponent's deck"
                }
                onAttack{
                  opp.deck.subList(0,self.cards.filterByType(ENERGY).filterByEnergyType(R).discard().size()).discard()
                }
            }
            move "Fire Spin" , {
                text "180 damage. Discard 3 Energy from this Pokémon."
                energyCost R,R,R,C
                onAttack{
                  damage 180
                  afterDamage{
                    discardSelfEnergy C,C,C
                  }
                }
            }
        };
        case LITTEN_20:
        return basic (this, hp:HP060, type:FIRE, retreatCost:1) {
            weakness WATER
            move "Fasten Claws" , {
                text "10+ damage. Flip a coin. If heads, this attack does 10 more damage."
                energyCost C
                onAttack{
                  damage 10
                  flip {damage 10}
                }
            }
        };
        case TORRACAT_21:
        return 	evolution (this, from:"Litten", hp:HP090, type:FIRE, retreatCost:2) {
            weakness WATER
            move "Roar" , {
                text "Your opponent switches their Active Pokémon with 1 of their Benched Pokémon.\n"
                energyCost C
                attackRequirement{
                    assert opp.bench : "There is no Pokémon on your opponent's bench"
                }
                onAttack{
                    sw opp.active, opp.bench.select("Choose the new active")
                }
            }
            move "Claw Slash" , {
                text "60 damage"
                energyCost C,C,C
                onAttack{
                  damage 60
                }
            }
        };
        case SQUIRTLE_22:
        return basic (this, hp:HP050, type:WATER, retreatCost:1) {
            weakness GRASS
            bwAbility "Floating Shell" , {
                text "If you have a Stadium card in play this Pokémon has no Retreat Cost."
                getterA (GET_RETREAT_COST,BEFORE_LAST ,self) {h->
      					  if(bg.stadiumInfoStruct.stadiumCard.player == self.owner) {
      					    h.object = 0
      					  }
      					}
            }
            move "Water Gun" , {
                text "30 damage"
                energyCost W,C
                onAttack{
                  damage 30
                }
            }
        };
        case SQUIRTLE_23:
        return basic (this, hp:HP070, type:WATER, retreatCost:1) {
            weakness GRASS
            move "Tackle" , {
                text "10 damage"
                energyCost C
                onAttack{
                  damage 10
                }
            }
            move "Rain Splash" , {
                text "20 damage"
                energyCost W,C
                onAttack{
                  damage 20
                }
            }
        };
        case WARTORTLE_24:
        return 	evolution (this, from:"Squirtle", hp:HP090, type:WATER, retreatCost:2) {
            weakness GRASS
            move "Tackle" , {
                text "30 damage"
                energyCost C,C
                onAttack{
                  damage 30
                }
            }
            move "Waterfall" , {
                text "70 damage"
                energyCost W,W,C
                onAttack{
                  damage 70
                }
            }
        };
        case BLASTOISE_25:
        return 	evolution (this, from:"Wartortle", hp:HP160, type:WATER, retreatCost:3) {
            weakness GRASS
            bwAbility "Powerful Squall" , {
                text "Once during your turn (before your attack), you may look at the top 6 cards of your deck and attach any number of [W] Energy cards you find there to your Pokémon in any way you like. Shuffle the other cards back into your deck."
                actionA{
                  checkLastTurn()
                  assert my.deck : "There is no more cards in your deck"
                  powerUsed()
                  my.deck.subList(0,6).showToMe("Top 6 cards of your deck")
      						def tar = my.deck.subList(0,6).filterByType(ENERGY).filterByEnergyType(W)
      						if(tar){
      							tar.select(min:0, max:tar.size(), "Select the ones you want to attach").each{
      								attachEnergy(my.all.select("Attach $it to?"), it)
      							}
      						}
      						shuffleDeck()
                }
            }
            move "Hydro Tackle" , {
                text "150 damage. This Pokémon does 30 damage to itself"
                energyCost W,W,C
                onAttack{
                  damage 150
                  damage 30, self
                }
            }
        };
        case PSYDUCK_26:
        return basic (this, hp:HP060, type:WATER, retreatCost:2) {
            weakness GRASS
            move "Headache" , {
                text "10 damage. Flip a coin. If heads, your opponent can't play any Trainer cards from their hand during their next turn."
                energyCost C
                onAttack{
                  damage 10
                  flip {
                    delayed{
      					      before PLAY_TRAINER, {
      					        if (bg.currentTurn == self.owner.opposite) {
      					           wcu "Bawl prevents playing trainer cards"
      					           prevent()
      					        }
                      }
      					  unregisterAfter 2
                }
              }
            }
          }
        };
        case GOLDUCK_27:
        return 	evolution (this, from:"Psyduck", hp:HP110, type:WATER, retreatCost:1) {
            weakness GRASS
            move "Amnesia" , {
                text "20 damage. Choose 1 of your opponent's Active Pokémon's attacks. That Pokémon can't use that attack during your opponent's next turn.\n"
                energyCost W
                onAttack{
                  damage 20
                  amnesia delegate
                }
            }
            move "Swim" , {
                text "90 damage. If any of your opponent's Pokémon have any [W] Energy attached to them, you may do 90 damage to 1 of your opponent’s Benched Pokémon instead of their Active Pokémon."
                energyCost C,C,C
                onAttack{
                  def applyEffect = false
                  opp.all.each{
                    if(it.cards.energyCount(W)){
                      applyEffect = true
                    }
                  }
                  if(applyEffect){
                    damage 90, opp.all.select("Choose the Pokémon to target for 90 damage")
                  }
                  else{
                    damage 90
                  }
                }
            }
        };
        case STARYU_28:
        return basic (this, hp:HP050, type:WATER, retreatCost:1) {
            weakness GRASS
            move "Numbing Water" , {
                text "10 damage. Flip a coin. If heads, your opponent's Active Pokémon is now Paralyzed."
                energyCost C
                onAttack{
                  damage 10
                  flipThenApplySC PARALYZED
                }
            }
        };
        case MAGIKARP_29:
        return basic (this, hp:HP030, type:WATER, retreatCost:1) {
            weakness LIGHTNING
            move "Enter the Dragon" , {
                text "Flip a coin. If heads, put a card that evolves from this Pokémon from your discard pile onto this Pokémon to evolve it."
                energyCost W
                attackRequirement{
                  assert my.discard.findAll{it.cardTypes.is(EVOLUTION) && self.name.contains(it.predecessor)}
                }
                onAttack{
                  def tar = my.discard.findAll{it.cardTypes.is(EVOLUTION) && self.name.contains(it.predecessor)}.select("Choose the card that will evolve from $self")
                  evolve(sel, tar.first(), OTHER)
                }
            }
        };
        case LAPRAS_30:
        return basic (this, hp:HP130, type:WATER, retreatCost:3) {
            weakness METAL
            move "Confuse Ray" , {
                text "Your opponent's Active Pokémon is now Confused.\n"
                energyCost W
                onAttack{
                  apply CONFUSED
                }
            }
            move "Hydro Pump" , {
                text "10+ damage. This attack does 30 more damage times the amount of Water Energy attached to this Pokémon."
                energyCost C
                onAttack{
                  damage 10 + 30* self.cards.energyCount(W)
                }
            }
        };
        case ARTICUNO_31:
        return basic (this, hp:HP110, type:WATER, retreatCost:2) {
            weakness LIGHTNING
            resistance FIGHTING, MINUS20
            bwAbility "Blizzard Veil" , {
                text "As long as this Pokémon is your Active Pokémon, whenever your opponent plays a Supporter card from their hand, prevent all effects of that card done to your Benched [W] Pokémon."
                delayedA{
                  before null, null, Source.SUPPORTER, {
                    def pcs = (ef as TargetedEffect).getResolvedTarget(bg, e)
      							if (self.active && pcs.cards.energyCount(W)){
      								bc "Blizzard Veil prevent effect of Supporter cards."
      								prevent()
      							}
      						}
                }
            }
            move "Cold Cyclone" , {
                text "70 damage. Move 2 [W] Energy from this Pokémon to 1 of your Benched Pokémon."
                energyCost W,W
                onAttack{
                  damage 70
                  afterDamage{
                    if(my.bench){
                      def tar = my.bench.select()
                      moveEnergy(type: WATER, self, tar)
                      moveEnergy(type: WATER, self, tar)
                    }
                  }
                }
            }
        };
        case PIKACHU_ZEKROM_GX_32:
        return basic (this, hp:HP240, type:LIGHTNING, retreatCost:3) {
            weakness FIGHTING
            resistance METAL, MINUS20
            move "Full Blitz" , {
                text "150 damage. Search your deck for up to 3 [L] Energy cards and attach them to 1 of your Pokémon. Then, shuffle your deck."
                energyCost L,L,L
                attackRequirement{
                  assert my.deck : "There is no more cards into your deck"
                }
                onAttack{
                  damage 150
                  afterDamage{
                    def list = my.deck.search (max: 3, basicEnergyFilter(L))
          					def pcs = my.all.select("To?")
          					list.each {attachEnergy(pcs, it)}
          					shuffleDeck()
                  }
                }
            }
            move "Tag Bolt GX" , {
                text "200 damage. If this Pokémon has at least 3 extra [L] Energy attached to it (in addition to this attack’s cost), this attack does 170 damage to 1 of your opponent’s Benched Pokémon."
                energyCost L,L,L
                attackRequirement {
                  gxCheck()
                }
                onAttack{
                    gxPerform()
                    damage 200
                    heal self.numberOfDamageCounters*10, self
                    if(opp.bench && self.cards.energySufficient(thisMove.energyCost() + L + L + L)){
                        damage 170, opp.bench.select("Choose the target for 170 damage")
                    }
                }
            }
        };
        case ALOLAN_GEODUDE_33:
        return basic (this, hp:HP060, type:LIGHTNING, retreatCost:2) {
            weakness FIGHTING
            resistance METAL, MINUS20
            move "Self-Destruct" , {
                text "60 damage. This Pokémon does 60 damage to itself."
                energyCost L,C
                onAttack{
                  damage 60
                  damage 60, self
                }
            }
        };
        case ALOLAN_GEODUDE_34:
        return basic (this, hp:HP070, type:LIGHTNING, retreatCost:3) {
            weakness FIGHTING
            resistance METAL, MINUS20
            move "Charge" , {
                text "Search your deck for up to 2 [L] Energy cards and attach them to this Pokémon. Then, shuffle your deck."
                onAttack{
                  attachEnergyFrom(type:L,my.deck,self)
                  attachEnergyFrom(type:L,my.deck,self)
                  shuffleDeck()
                }
            }
            move "Smash Bomb" , {
                text "50 damage. Flip a coin. If tails, this attack does nothing."
                energyCost L,C,C
                onAttack{
                  flip 1,{damage 50},{bc "$thisMove missed."}
                }
            }
        };
        case ALOLAN_GRAVELER_35:
        return 	evolution (this, from:"Alolan Geodude", hp:HP100, type:LIGHTNING, retreatCost:4) {
            weakness FIRE
            resistance METAL, MINUS20
            move "Rollout" , {
                text "30 damage"
                onAttack{
                  damage 30
                }
            }
            move "Electroslug" , {
                text "100 damage"
                energyCost L,C,C,C
                onAttack{
                  damage 100
                }
            }
        };
        case ALOLAN_GOLEM_36:
        return 	evolution (this, from:"Alolan Graveler", hp:HP180, type:LIGHTNING, retreatCost:4) {
            weakness FIGHTING
            resistance METAL, MINUS20
            move "Electromagnetic Bomb" , {
                text "20× damages. Move any number of [L] Energy from your Benched Pokémon to this Pokémon. This attack does 20 damage for each Energy card you moved in this way."
                attackRequirement{
                  assert my.all.findAll {it.cards.filterByEnergyType(L) && it!=self} : "There is no Energy to move"
                }
                onAttack{
                  def dmgCount = 0
                  while(1){
    								def pl=(my.all.findAll {it.cards.filterByEnergyType(L) && it!=self})
    								if(!pl) break;
    								def src=pl.select("Source for [L] energy (cancel to stop moving)", false)
    								if(!src) break;
    								def card=src.cards.filterByEnergyType(L).select("Card to move").first()
    								energySwitch(src, self, card)
                    dmgCount += 20
    							}
                  damage dmgCount
                }
            }
            move "Super Zap Cannon" , {
                text "190 damage. Discard 2 Energy from this Pokémon."
                energyCost L,C,C,C,C
                onAttack{
                  damage 190
                  discardSelfEnergy C,C
                }
            }
        };
        case VOLTORB_37:
        return basic (this, hp:HP050, type:LIGHTNING, retreatCost:1) {
            weakness FIGHTING
            resistance METAL, MINUS20
            move "Tackle" , {
                text "20 damage"
                energyCost C
                onAttack{
                  damage 20
                }
            }
        };
        case ELECTRODE_38:
        return 	evolution (this, from:"Voltorb", hp:HP090, type:LIGHTNING, retreatCost:1) {
            weakness FIGHTING
            resistance METAL, MINUS20
            bwAbility "Electro Shaker" , {
                text "When you play this Pokémon from your hand to evolve 1 of your Pokémon during your turn, you may move any number of [L] Energy from your Pokémon to your other Pokémon in any way you like."
                onActivate {r->
      						if(r==PLAY_FROM_HAND && confirm('Use Electro Shaker?')){
      							powerUsed()
                    while(1){
                      def pl=(my.all.findAll {it.cards.energyCount(L)})
                      if(!pl) break;
                      def src =pl.select("source for energy (cancel to stop)", false)
                      if(!src) break;
                      def card=src.cards.filterByEnergyType(L).select("Card to move").first()

                      def tar=my.all.select("Target for energy (cancel to stop)", false)
                      if(!tar) break;
                      energySwitch(src, tar, card)
                    }
      						}
      					}
            }
            move "Speed Ball" , {
                text "50 damage"
                energyCost L,C
                onAttack{
                  damage 50
                }
            }
        };
        case ZAPDOS_39:
        return basic (this, hp:HP110, type:LIGHTNING, retreatCost:2) {
            weakness LIGHTNING
            resistance FIGHTING, MINUS20
            move "Thunderous Assault" , {
                text "10+ damage. If this Pokémon was on the Bench and became your Active Pokémon this turn, this attack does 70 more damage. This attack's damage isn't affected by Weakness."
                energyCost L
                onAttack {
      						noWeaknessDamage(10,defending)
                  if(wasSwitchedOutThisTurn(self))
      							noWeaknessDamage(70,defending)
      					}
            }
        };
        case MAREEP_40:
        return basic (this, hp:HP060, type:LIGHTNING, retreatCost:1) {
            weakness LIGHTNING
            resistance METAL, MINUS20
            move "Shock Bolt" , {
                text "30 damage. Discard all [L] Energy from this Pokémon."
                energyCost L
                onAttack{
                  damage 30
                  afterDamage{
                    discardAllSelfEnergy(L)
                  }
                }
            }
        };
        case FLAAFFY_41:
        return 	evolution (this, from:"Mareep", hp:HP090, type:LIGHTNING, retreatCost:2) {
            weakness FIGHTING
            resistance FIGHTING, MINUS20
            move "Electric Punch" , {
                text "30 damage"
                energyCost L
                onAttack{
                  damage 30
                }
            }
            move "Shock Bolt" , {
                text "60 damage. Discard all [L] Energy from this Pokémon."
                energyCost L,L
                onAttack{
                  damage 60
                  afterDamage{
                    discardAllSelfEnergy(L)
                  }
                }
            }
        };
        case AMPHAROS_GX_42:
        return 	evolution (this, from:"Flaaffy", hp:HP240, type:LIGHTNING, retreatCost:3) {
            weakness FIGHTING
            resistance METAL, MINUS20
            move "Power Charge" , {
                text "30 damage. Put all Electropower cards from your discard pile into your hand.\n"
                energyCost L
                onAttack{
                  damage 30
                  my.discard.findAll{it.name.contains("Electropower")}.moveTo(my.hand)
                }
            }
            move "Impact Bolt" , {
                text "150 damage. Discard all [L] Energy from this Pokémon"
                energyCost L,L
                onAttack{
                  damage 150
                  afterDamage{
                    discardAllSelfEnergy(L)
                  }
                }
            }
            move "Electrical GX" , {
                text "Search your deck for up to 7 Pokémon, reveal them, and put them into your hand. Then, shuffle your deck."
                energyCost L
                attackRequirement {
                  gxCheck()
                }
                onAttack{
                    gxPerform()
                    my.deck.search(max:7,"Choose up to 7 Pokémon Cards",cardTypeFilter(POKEMON)).showToOpponent("Chosen Pokémon").moveTo(my.hand)
                    shuffleDeck()
                }
            }
        };
        case BLITZLE_43:
        return basic (this, hp:HP060, type:LIGHTNING, retreatCost:1) {
            weakness FIGHTING
            resistance METAL, MINUS20
            move "Delivery Dash" , {
                text "Search your deck for up to 2 Electropower cards, reveal them, and put them into your hand. Then, shuffle your deck.\n"
                energyCost L
                attackRequirement{
                  assert my.deck : "there is no more cards in your deck"
                }
                onAttack{
                  my.deck.search(max:2,"Choose up to 2 Electropower cards",{it.name.contains("Electropower")}).showToOpponent("Chosen cards").moveTo(my.hand)
                }
            }
            move "Zap Kick" , {
                text "20 damage"
                energyCost L,L
                onAttack{
                  damage 20
                }
            }
        };
        case ZEBSTRIKA_44:
        return 	evolution (this, from:"Blitzle", hp:HP120, type:LIGHTNING, retreatCost:1) {
            weakness FIGHTING
            resistance METAL, MINUS20
            move "Raid" , {
                text "30+ damage. If this Pokémon evolved from Blitzle during this turn, this attack does 90 more damage.\n"
                energyCost L,C
                onAttack{
                  damage 30
                  if(self.lastEvolved == bg.turnCount){
                    damage 90
                  }
                }
            }
            move "Mach Bolt" , {
                text "100 damage"
                energyCost L,L,C
                onAttack{
                  damage 100
                }
            }
        };
        case EMOLGA_45:
        return basic (this, hp:HP060, type:LIGHTNING, retreatCost:0) {
            weakness LIGHTNING
            resistance FIGHTING, MINUS20
            bwAbility "Nuzzly Gathering" , {
                text "Once during your turn (before your attack), you may search your deck for a Pokémon that has the Nuzzle attack, reveal it, and put it into your hand. Then, shuffle your deck."
                actionA{
                  checkLastTurn()
                  assert my.deck : "There is no more cardds in your deck"
                  powerUsed()
                  my.deck.search(count : 1,"",it.topPokemonCard.moves.findAll{it.name=="Nuzzle"}).showToOpponent("Chosen Pokémon").moveTo(my.hand)

                }
            }
            move "Nuzzle" , {
                text "Flip a coin. If heads, your opponent's Active Pokémon is now Paralyzed."
                energyCost L
                onAttack{
                  flip{apply PARALYZED}
                }
            }
        };
        case JOLTIK_46:
        return basic (this, hp:HP040, type:LIGHTNING, retreatCost:1) {
            weakness FIGHTING
            resistance METAL, MINUS20
            move "Leech Life" , {
                text "10 damage. Heal from this Pokémon the same amount of damage you did to your opponent's Active Pokémon."
                energyCost L
                onAttack{
                  damage 10
                  removeDamageCounterEqualToDamageDone()
                }
            }
        };
        case GALVANTULA_47:
        return 	evolution (this, from:"Joltik", hp:HP090, type:LIGHTNING, retreatCost:1) {
            weakness FIGHTING
            resistance METAL, MINUS20
            bwAbility "Unnerve" , {
                text "Whenever your opponent plays an Item or Supporter card from their hand, prevent all effects of that card done to this Pokémon."
                delayedA {
      						before null, self, Source.TRAINER_CARD, {
      							if (bg.currentThreadPlayerType != self.owner){
      								bc "Unnerve prevent effect of item"
      								prevent()
      							}
      						}
      					}
            }
            move "Spider Thread" , {
                text "40 damage. Put a card from your discard pile into your hand."
                energyCost L
                onAttack{
                  damage 40
                  afterDamage{
                    if(my.discard){
                      my.discard.select("Choose the card to move into your hand").moveTo(my.hand)
                    }
                  }
                }
            }
        };
        case HELIOPTILE_48:
        return basic (this, hp:HP060, type:LIGHTNING, retreatCost:1) {
            weakness FIGHTING
            resistance METAL, MINUS20
            move "Pound" , {
                text "10 damage"
                energyCost C
                onAttack{
                  damage 10
                }
            }
            move "Static Shock" , {
                text "40 damage"
                energyCost L,C,C
                onAttack{
                  damage 40
                }
            }
        };
        case HELIOLISK_49:
        return 	evolution (this, from:"Helioptile", hp:HP100, type:LIGHTNING, retreatCost:1) {
            weakness FIGHTING
            resistance METAL, MINUS20
            move "Random Spark" , {
                text "This attack does 30 damage to 1 of your opponent's Pokémon."
                energyCost L
                onAttack{
                  damage 30, opp.all.select()
                }
            }
            move "Volt Switch" , {
                text "90 damage. Switch this Pokémon with 1 of your Benched Lightning Pokémon."
                energyCost L,C,C
                onAttack{
                  damage 90
                  if(my.bench.findAll{it.types.contains(W)}){
                    sw self,my.bench.findAll{it.types.contains(W)}.select()
                  }
                }
            }
        };
        case TAPU_KOKO_PRISM_STAR_50:
        return basic (this, hp:HP130, type:LIGHTNING, retreatCost:1) {
            weakness FIGHTING
            resistance METAL, MINUS20
            bwAbility "Dance of the Ancients" , {
                text "Once during your turn (before your attack), if this Pokémon is on your Bench, you may choose 2 of your Benched Pokémon and attach a [L] Energy card from your discard pile to each of them. If you do, discard all cards from this Pokémon and put it in the Lost Zone."
                actionA{
                  checkLastTurn()
                  assert !self.active : "$self is not benched."
                  assert my.discard.filterByType(ENERGY).filterByEnergyType(L) : "There is no Lightning energy in the discard"
                  powerUsed()
                  attachEnergyFrom(type:L,my.discard,my.bench)
                  attachEnergyFrom(may: true,type:L,my.discard,my.bench)
                  self.cards.discard()
                }
            }
            move "Mach Bolt" , {
                text "120 damage"
                energyCost L,L,C
                onAttack{
                  damage 120
                }
            }
        };
        case ZERAORA_51:
        return basic (this, hp:HP120, type:LIGHTNING, retreatCost:1) {
            weakness FIGHTING
            resistance METAL, MINUS20
            move "Slash" , {
                text "20 damage"
                energyCost C
                onAttack{
                  damage 20
                }
            }
            move "Wild Charge" , {
                text "120 damage. This Pokémon does 20 damage to itself."
                energyCost L,L,C
                onAttack{
                  damage 120
                  damage 20, self
                }
            }
        };
        case GENGAR_MIMIKYU_GX_52:
        return basic (this, hp:HP240, type:PSYCHIC, retreatCost:2) {
            weakness DARKNESS
            resistance FIGHTING, MINUS20
            move "Poltergeist" , {
                text "50× damage. Your opponent reveals their hand. This attack does 50 damage for each Trainer card you find there.\n"
                energyCost P,P
                onAttack{
                  if(opp.hand){
                    opp.hand.showToMe("Your opponent's hand")
                    damage 50*opp.hand.filterByType(TRAINER_CARD)
                  }
                }
            }
            move "Horror House GX" , {
                text "Your opponent can't play any cards from their hand during their next turn. If this Pokémon has at least 1 extra [P] Energy attached to it (in addition to this attack’s cost), each player draws cards until they have 7 cards in their hand."
                energyCost P
                attackRequirement{
                  gxCheck()
                }
                onAttack{
                  gxPerform()
                  if(self.cards.energySufficient(thisMove.energyCost() + P)){
                      draw 7-my.hand
                      draw 7-opp.hand, TargetPlayer.OPPONENT
                      shuffleDeck()
                  }
                  delayed{
                    before PLAY_CARD, {
                      if (bg.currentTurn == self.owner.opposite) {
                        wcu "Horror House GX prevents playing this card"
                        prevent()
                      }
                    }
                    unregisterAfter 2
                  }
                }
            }
        };
        case NIDORAN_FEMALE_53:
        return basic (this, hp:HP060, type:PSYCHIC, retreatCost:1) {
            weakness PSYCHIC
            move "Call for Family" , {
                text "Search your deck for a Basic Pokémon and put it onto your Bench. Then, shuffle your deck.\n"
                energyCost C
                callForFamily(basic:true,1,delegate)
            }
            move "Scratch" , {
                text "20 damage"
                energyCost C,C
                onAttack{
                  damage 20
                }
            }
        };
        case NIDORINA_54:
        return 	evolution (this, from:"Nidoran Female", hp:HP090, type:PSYCHIC, retreatCost:2) {
            weakness PSYCHIC
            move "Family Rescue" , {
                text "Shuffle 5 Psychic Pokémon from your discard pile into your deck.\n"
                energyCost C
                attackRequirement{
                  assert my.discard.findAll{it.cardTypes.pokemon && it.asPokemonCard().types.contains(P)}
                }
                onAttack{
                  my.discard.findAll{it.cardTypes.pokemon && it.asPokemonCard().types.contains(P)}.select(max:5,"Choose the Pokémon to put back in deck").moveTo(my.deck)
                  shuffleDeck()
                }
            }
            move "Bite" , {
                text "30 damage"
                energyCost C,C
                onAttack{
                  damage 30
                }
            }
        };
        case NIDOQUEEN_55:
        return 	evolution (this, from:"Nidorina", hp:HP160, type:PSYCHIC, retreatCost:3) {
            weakness PSYCHIC
            bwAbility "Queen's Call" , {
                text "Once during your turn (before your attack), you may search your deck for a Pokémon that isn't a Pokémon-GX or Pokémon-EX, reveal it, and put it into your hand. Then, shuffle your deck."
                actionA{
                  checkLastTurn()
                  assert my.deck : "There is no more card in your deck"
                  my.deck.search(count:1,"Select one Pokémon that isn't a Pokémon-GX or Pokémon-EX",{it.cardTypes.is(POKEMON) && !it.cardTypes.is(POKEMON_GX) && !it.cardTypes.is(POKEMON_EX)}).showToOpponent("Chosen Pokémon").moveTo(my.hand)
                  shuffleDeck
                }
            }
            move "Power Lariat" , {
                text "10+ damage. This attack does 50 more damage for each Evolution Pokémon on your Bench."
                energyCost C,C,C
                onAttack{
                  damage 10
                  my.bench.each{
                    if(it.evolution){
                      damage 50
                    }
                  }
                }
            }
        };
        case NIDORAN_MALE_56:
        return basic (this, hp:HP060, type:PSYCHIC, retreatCost:1) {
            weakness PSYCHIC
            move "Peck" , {
                text "10 damage"
                energyCost C
                onAttack{
                  damage 10
                }
            }
            move "Horn Attack" , {
                text "20 damage"
                energyCost P,C
                onAttack{
                  damage 20
                }
            }
        };
        case NIDORINO_57:
        return 	evolution (this, from:"Nidoran Male", hp:HP090, type:PSYCHIC, retreatCost:2) {
            weakness PSYCHIC
            move "Peck" , {
                text "20 damage"
                energyCost C
                onAttack{
                  damage 20
                }

            }
            move "Horn Drill" , {
                text "60 damage"
                energyCost P,C,C
                onAttack{
                  damage 60
                }
            }
        };
        case NIDOKING_58:
        return 	evolution (this, from:"Nidorino", hp:HP160, type:PSYCHIC, retreatCost:3) {
            weakness PSYCHIC
            move "Drag Off" , {
                text "Switch 1 of your opponent's Benched Pokémon with their Active Pokémon. This attack does 50 damage to the new Active Pokémon.\n"
                energyCost C,C
                onAttack{
                  def tar = defending
                  if(opp.bench){
                    tar = opp.bench.select("Select the new active")
                    sw defending, tar
                  }
                  damage 50, tar
                }
            }
            move "King's Drum" , {
                text "100+ damage. If Nidoqueen is on your Bench, this attack does 100 more damage."
                energyCost P,C,C
                onAttack{
                  def moreDmg = false
                  damage 100
                  my.bench.each {
                      if(it.name.contains("Nidoqueen")){
                        moreDmg = true
                      }
                  }
                  if(moreDmg){
                    damage 100
                  }
                }
            }
        };
        case TENTACOOL_59:
        return basic (this, hp:HP060, type:PSYCHIC, retreatCost:1) {
            weakness PSYCHIC
            move "Wrap" , {
                text "10 damage. Flip a coin. If heads, your opponent's Active Pokémon is now Paralyzed."
                energyCost C
                onAttack{
                  damage 10
                  flipThenApplySC PARALYZED
                }
            }
        };
        case TENTACRUEL_60:
        return 	evolution (this, from:"Tentacool", hp:HP100, type:PSYCHIC, retreatCost:1) {
            weakness PSYCHIC
            move "Void Tentacles" , {
                text "Your opponent's Active Pokémon is now Confused and Poisoned.\n"
                energyCost C
                onAttack{
                  apply CONFUSED
                  apply POISONED
                }
            }
            move "Paranormal" , {
                text "70 damage. During your opponent's next turn, prevent all damage done to this Pokémon by attacks from Ultra Beasts."
                energyCost P,C,C
                onAttack{
                  damage 70
                  delayed{
                    before APPLY_ATTACK_DAMAGES, {
        							bg.dm().each {
        								if(it.to == self && it.from.cardTypes.is(ULTRA_BEAST) && it.dmg.value && it.notNoEffect) {
        									bc "Paranormal prevents damage from Ultra Beasts"
        									it.dmg = hp(0)
                        }
      								}
      							}
      						}
                }
            }
        };
        case GRIMER_61:
        return basic (this, hp:HP080, type:PSYCHIC, retreatCost:2) {
            weakness PSYCHIC
            move "Pound" , {
                text "10 damage"
                energyCost C
                onAttack{
                  damage 10
                }
            }
        };
        case MUK_62:
        return 	evolution (this, from:"Grimer", hp:HP130, type:PSYCHIC, retreatCost:4) {
            weakness PSYCHIC
            bwAbility "Poison Sacs" , {
                text "The Special Condition Poisoned is not removed when your opponent's Pokémon evolve or devolve."
                delayedA{
                  before POISONED_SPC, null, null, EVOLVE, {
                    if(ef.target == self.owner.opposite){
                      prevent()
                    }
                  }
                }
            }
            move "Toxic Secretion" , {
                text "40 damage. Your opponent's Active Pokémon is now Poisoned. Put 2 damage counters instead of 1 on that Pokémon between turns."
                energyCost P
                onAttack{
                  damage 40
                  afterDamage{
                    apply POISONED
                    extraPoison 1
                  }
                }
            }
        };
        case ALOLAN_MAROWAK_63:
        return 	evolution (this, from:"Cubone", hp:HP120, type:PSYCHIC, retreatCost:2) {
            weakness DARKNESS
            resistance FIGHTING, MINUS20
            move "Limbo Limbo" , {
                text "Search your deck for up to 2 basic Energy cards and attach them to your Pokémon in any way you like. Then, shuffle your deck.\n"
                onAttack{
                  attachEnergyFrom(basic:true,my.deck,my.all)
                  attachEnergyFrom(basic:true,my.deck,my.all)
                  shuffleDeck()
                }
            }
            move "Alolan Club" , {
                text "20× damage. This attack does 20 damage for each of your Pokémon in play that has Alolan in its name."
                energyCost C,C
                onAttack{
                  my.all.each{
                    if(it.name.contains("Alolan")){
                      damage 20
                    }
                  }
                }
            }
        };
        case STARMIE_64:
        return 	evolution (this, from:"Staryu", hp:HP080, type:PSYCHIC, retreatCost:0) {
            weakness PSYCHIC
            move "Strange Wave" , {
                text "40 damage. Search your deck for up to 3 in any combination of [W] and [P] Energy cards and attach them to 1 of your Benched Pokémon. Then, shuffle your deck"
                energyCost C
                onAttack{
                  damage 40
                  afterDamage{
                    if(my.deck){
                      def enSel = my.deck.search(max:3,"Select up to 3 in any combination of [W] and [P] Energy cards",{it.cardTypes.is(ENERGY) && (it.asEnergyCard().containsTypePlain(W) || it.asEnergyCard().containsTypePlain(P))})
                      def tar = my.all.select("Attach the energy to?")
                      enSel.each{
                        attachEnergyFrom(it,tar)
                      }
                      shuffleDeck()
                    }
                  }
                }
            }
        };
        case MR_MIME_65:
        return basic (this, hp:HP080, type:PSYCHIC, retreatCost:1) {
            weakness PSYCHIC
            bwAbility "Scoop-Up Block" , {
                text "Your opponent's Pokémon that have any damage counters on them, and any cards attached to those Pokémon, can't be put into your opponent's hand."
                //TODO: find a way to block scoop up effects
            }
            move "Psy Bolt" , {
                text "20 damage. Flip a coin. If heads, your opponent's Active Pokémon is now Paralyzed."
                energyCost C,C
                onAttack{
                  damage 20
                  flipThenApplySC PARALYZED
                }
            }
        };
        case MR_MIME_GX_66:
        return basic (this, hp:HP150, type:PSYCHIC, retreatCost:2) {
            bwAbility "Magic Odds" , {
                text "Prevent all damage done to this Pokémon by your opponent's attacks if that damage is exactly 10, 30, 50, 70, 90, 110, 130, 150, 170, 190, 210, 230, or 250."
                delayedA {
                  before APPLY_ATTACK_DAMAGES, {
                    bg.dm().each{
                      if(it.to == self && it.notNoEffect && (it.dmg.value == 10 || it.dmg.value == 30 || it.dmg.value == 50 || it.dmg.value == 70 || it.dmg.value == 90 || it.dmg.value == 110 || it.dmg.value == 130 || it.dmg.value == 150  || it.dmg.value == 170  || it.dmg.value == 190  || it.dmg.value == 210  || it.dmg.value == 230  || it.dmg.value == 250)) {
                        bc "Magic Odds prevent damage"
                        it.dmg = hp(0)
                      }
                    }
                  }
                }
            }
            move "Breakdown" , {
    					text "For each card in your opponent's hand, put 1 damage counter on their Active Pokémon."
    					energyCost P,C
    					onAttack {
    					  directDamage 10*opp.hand.size(), defending
    					}
    				}
    				move "Life Trick GX" , {
    					text "Heal all damage from this Pokémon. (You can't use more than 1 GX attack in a game.)"
    					energyCost C
    					attackRequirement{
    					  gxCheck()
    					}
    					onAttack{
    					  gxPerform()
    					  heal self.numberOfDamageCounters*10, self
    					}
    				}
    			};
        case JYNX_67:
        return basic (this, hp:HP090, type:PSYCHIC, retreatCost:1) {
            weakness PSYCHIC
            move "Dazzle Dance" , {
                text "Your opponent's Active Pokémon is now Confused."
                energyCost C
                onAttack{
                  apply CONFUSED
                }
            }
            move "Mysterious Dance" , {
                text "For each of your opponent's Benched Pokémon, put 1 damage counter on your opponent's Pokémon in any way you like."
                energyCost P,C
                attackRequirement{
                  assert opp.bench : "There is no benched pokémon"
                }
                onAttack{
                  opp.bench.each{
                    directDamage 10, opp.all.select("Put 1 damage counter to which Pokémon")
                  }
                }
            }
        };
        case COSMOG_68:
        return basic (this, hp:HP050, type:PSYCHIC, retreatCost:1) {
            weakness PSYCHIC
            bwAbility "Cosmic Guard" , {
                text "As long as this Pokémon is on your Bench, prevent all damage done to this Pokémon by attacks (both yours and your opponent's)."
                delayedA {
                  before APPLY_ATTACK_DAMAGES, {
                    bg.dm().each{
                      if(!self.active && it.to == self){
                        bc "Cosmic Guard prevent all damage"
                        it.dmg=hp(0)
                      }
                    }
                  }
                }
            }
            move "Mumble" , {
                text "10 damage"
                energyCost C
                onAttack{
                  damage 10
                }
            }
        };
        case COSMOEM_69:
        return 	evolution (this, from:"Cosmog", hp:HP100, type:PSYCHIC, retreatCost:3) {
            weakness PSYCHIC
            move "Nap" , {
                text "Heal 20 damage from this Pokémon."
                energyCost C
                onAttack{
                  heal 20, self
                }
            }
        };
        case MANKEY_70:
        return basic (this, hp:HP050, type:FIGHTING, retreatCost:1) {
            weakness PSYCHIC
            move "Scout" , {
                text "You opponent reveals their hand."
                energyCost C
                onAttack{
                  opp.hand.showToMe("Your opponent's hand")
                }
            }
            move "Low Kick" , {
                text "30 damage"
                energyCost F,C
                onAttack{damage 30}
            }
        };
        case PRIMEAPE_71:
        return 	evolution (this, from:"Mankey", hp:HP090, type:FIGHTING, retreatCost:1) {
            weakness PSYCHIC
            move "Low Kick" , {
                text "30 damage"
                energyCost F
                onAttack{
                  damage 30
                }
            }
            move "Wreck" , {
                text "80+ damage. If there is any Stadium card in play, this attack does 80 more damage. Then, discard that Stadium card."
                energyCost F,C,C
                onAttack{
                  damage 80
                  afterDamage {
      							if(bg.stadiumInfoStruct){
      								discard bg.stadiumInfoStruct.stadiumCard
      							}
      						}
                }
            }
        };
        case HITMONLEE_72:
        return basic (this, hp:HP100, type:FIGHTING, retreatCost:1) {
            weakness PSYCHIC
            move "Special Combo" , {
                text "This attack can be used only if Hitmonchan used Hit and Run during your last turn. This attack does 90 damage to 1 of your opponent's Benched Pokémon. (Don't apply Weakness and Resistance for Benched Pokémon.)\n"
                energyCost F
                attackRequirement{
                  assert bg.em().retrieveObject("Hit_And_Run"+thisCard.player) == bg.turnCount -2 : "Hitmonchan did not used Hit and Run during your last turn"
                  assert opp.bench : "There is no benched Pokémon"
                }
                onAttack{
                  damage 90, opp.bench.select()
                }
            }
            move "Mega Kick" , {
                text "90 damage"
                energyCost F,F,C
                onAttack{
                  damage 90
                }
            }
        };
        case HITMONCHAN_73:
        return basic (this, hp:HP090, type:FIGHTING, retreatCost:1) {
            weakness PSYCHIC
            move "Hit and Run" , {
                text "30 damage. You may switch this Pokémon with 1 of your Benched Pokémon.\n"
                energyCost F
                onAttack{
                  damage 30
                  bg.em().storeObject("Hit_And_Run", bg.turnCount)
                  if(my.bench && confirm("Switch $self with 1 of your Benched Pokémon")){
                    sw self, my.bench.select("New active")
                  }
                }
            }
            move "Magnum Punch" , {
                text "70 damage"
                energyCost F,C,C
                onAttack{
                  damage 70
                }
            }
        };
        case OMANYTE_74:
        return 	evolution (this, from:"Unidentified Fossil", hp:HP090, type:FIGHTING, retreatCost:1) {
            weakness GRASS
            move "Tickle" , {
                text "30 damage. Flip a coin. If heads, your opponent's Active Pokémon is now Paralyzed."
                energyCost C
                onAttack{
                  damage 30
                  flipThenApplySC PARALYZED
                }
            }
        };
        case OMASTAR_75:
        return 	evolution (this, from:"Omanyte", hp:HP130, type:FIGHTING, retreatCost:2) {
            weakness GRASS
            bwAbility "Fossil Bind" , {
                text "As long as you have fewer Pokémon in play than your opponent, they can't play any item cards from their hand."
                delayedA{
                  before PLAY_TRAINER, {
                    if (ef.cardToPlay.cardTypes.is(ITEM) && bg.currentTurn == self.owner.opposite && my.all.size() < opp.all.size()) {
                      wcu "Fossil Bind prevents playing this card"
                      prevent()
                    }
                  }
                }
            }
            move "Bite" , {
                text "60 damage"
                energyCost F,C
                onAttack{
                  damage 60
                }
            }
        };
        case KABUTO_76:
        return 	evolution (this, from:"Unidentified Fossil", hp:HP090, type:FIGHTING, retreatCost:1) {
            weakness GRASS
            move "Ramming Shell" , {
                text "40 damage. During your opponent's next turn, this Pokémon takes 20 less damage from attacks (after applying Weakness and Resistance)."
                energyCost F
                onAttack{
                  damage 40
                  reduceDamageNextTurn(hp(20),thisMove)
                }
            }
        };
        case KABUTOPS_77:
        return 	evolution (this, from:"Kabuto", hp:HP140, type:FIGHTING, retreatCost:2) {
            weakness GRASS
            bwAbility "Fossilized Memories" , {
                text "As long as this Pokémon is your Active Pokémon, your opponent can't play any Supporter cards from their hand."
                before PLAY_TRAINER, {
                  if (ef.cardToPlay.cardTypes.is(SUPPORTER) && bg.currentTurn == self.owner.opposite && self.active) {
                    wcu "Fossilized Memories prevents playing this card"
                    prevent()
                  }
                }
            }
            move "Rock Slide" , {
                text "80 damage. This attack does 20 damage to 2 of your opponent's Benched Pokémon. (Don't apply Weakness and Resistance for Benched Pokémon.)"
                energyCost F,C,C
                onAttack{
                  damage 80
                  if(opp.bench){
                    multiSelect(opp.bench, 2).each{
        					    targeted(it){
        					      damage 20, it
        					    }
        					  }
                  }
                }
            }
        };
        case LARVITAR_78:
        return basic (this, hp:HP070, type:FIGHTING, retreatCost:2) {
            weakness GRASS
            move "Chip Away" , {
                text "30 damage. This attack's damage isn't affected by any effects on your opponent's Active Pokémon."
                energyCost C,C
                onAttack{
                  shredDamage 30,defending
                }
            }
        };
        case PUPITAR_79:
        return 	evolution (this, from:"Larvitar", hp:HP080, type:FIGHTING, retreatCost:1) {
            weakness GRASS
            move "Payback" , {
                text "30+ damage. If your opponent has exactly 1 Prize card remaining, this attack does 90 more damage"
                energyCost C,C
                onAttack{
                  damage 30
                  if(my.prizeCardSet.size() == 1){
                    damage 90
                  }
                }
            }
        };
        case PANCHAM_80:
        return basic (this, hp:HP060, type:FIGHTING, retreatCost:2) {
            weakness PSYCHIC
            move "Arm Thrust" , {
                text "40 damage. Flip a coin. If heads, discard an Energy from your opponent's Active Pokémon. If tails, this attack does nothing."
                energyCost C,C
                onAttack{
                  flip 1,{damage 40;
                    afterDamage{discardDefendingEnergy()}},{bc "$thisMove failed "}
                }
            }
        };
        case LYCANROC_GX_81:
        return 	evolution (this, from:"Rockruff", hp:HP200, type:FIGHTING, retreatCost:2) {
            weakness GRASS
            bwAbility "Twilight Eyes" , {
                text "When you play this Pokémon from your hand to evolve 1 of your Pokémon during your turn, you may discard an Energy from your opponent's Active Pokémon."
                onActivate {r->
      						if(r==PLAY_FROM_HAND && confirm('Use Twilight Eyes?')){
      							powerUsed()
      							discardDefendingEnergy()
      						}
      					}
            }
            move "Accelerock" , {
                text "120 damage"
                energyCost F,C,C
                onAttack{
                  damage 120
                }
            }
            move "Splintered Shards GX" , {
                text "30× damage. This attack does 30 damage for each Energy card in your opponent's discard pile. (You can't use more than 1 GX attack in a game.)\nPokémon-GX rule: When your Pokémon-GX is Knocked Out, your opponent takes 2 Prize cards."
                energyCost F
                attackRequirement{
                  assert opp.discard : "There is no card in your opponent's discard pile"
                }
                onAttack{
                  gxPerform
                  damage 30*opp.discard.filterByType(ENERGY).size()
                }
            }
        };
        case ALOLAN_GRIMER_82:
        return basic (this, hp:HP070, type:DARKNESS, retreatCost:3) {
            weakness FIGHTING
            resistance PSYCHIC, MINUS20
            move "Chemical Breath" , {
                text "20+ damage. This attack does 50 more damage for each Special Condition affecting your opponent's Active Pokémon."
                energyCost C,C
                onAttack{
                  damage 20+50*defending.specialConditions.size()
                }
            }
        };
        case ALOLAN_MUK_83:
        return 	evolution (this, from:"Alolan Grimer", hp:HP120, type:DARKNESS, retreatCost:3) {
            weakness FIGHTING
            resistance PSYCHIC, MINUS20
            bwAbility "Adventurous Appetite" , {
                text "When you play this Pokémon from your hand to evolve 1 of your Pokémon during your turn, you may look at the top 6 cards of your opponent's deck and discard any number of Item cards you find there. Your opponent shuffles the other cards back into their deck."
                onActivate {r->
      						if(r==PLAY_FROM_HAND && confirm('Use Adventurous Appetite?')){
      							powerUsed()
      							opp.deck.subList(0,6).showToMe("Top 6 cards of your opponent's deck")
                    def tar = opp.deck.subList(0,6).filterByType(ITEM)
                    if(tar){
                      tar.select(max:tar.size(),"Choose the item to discard").discard()
                    }
      						}
      					}
            }
            move "Gunk Shot" , {
                text "80 damage. Your opponent's Active Pokémon is now Poisoned."
                energyCost D,C,C
                onAttack{
                  damage 80
                  afterDamage{
                    apply POISONED
                  }
                }
            }
        };
        case TYRANITAR_84:
        return 	evolution (this, from:"Pupitar", hp:HP170, type:DARKNESS, retreatCost:4) {
            weakness FIGHTING
            resistance PSYCHIC, MINUS20
            move "Spinning Tail" , {
                text "This attack does 30 damage to each of your opponent's Pokémon. (Don't apply Weakness and Resistance for Benched Pokémon.)\n"
                energyCost D,C,C
                onAttack{
                  opp.all.each{
                    damage 30,it
                  }
                }
            }
            move "Bite Off" , {
                text "130+ damage. If your opponent's Active Pokémon is a Pokémon-GX or a Pokémon-EX, this attack does 100 more damage (before applying Weakness and Resistance)."
                energyCost D,C,C,C
                onAttack{
                  damage 130
                  if(defending.pokemonEX && defending.pokemonGX){
                    damage 100
                  }
                }
            }
        };
        case POOCHYENA_85:
        return basic (this, hp:HP070, type:DARKNESS, retreatCost:1) {
            weakness FIGHTING
            resistance PSYCHIC, MINUS20
            move "Howl in the Dark" , {
                text "Search your deck for up to 2 [D] Pokémon, reveal them, and put them into your hand. Then, shuffle your deck."
                energyCost C
                onAttack{
                  my.deck.search(max:2,"Choose 2 [D] Pokémon",{it.cardTypes.is(POKEMON) && it.asPokemonCard.types.contains(D)}).moveTo(my.hand)
                  shuffleDeck()
                }
            }
            move "Bite" , {
                text "10 damage"
                energyCost D
                onAttack{
                  damage 10
                }
            }
        };
        case MIGHTYENA_86:
        return 	evolution (this, from:"Poochyena", hp:HP100, type:DARKNESS, retreatCost:1) {
            weakness FIGHTING
            resistance PSYCHIC, MINUS20
            move "Bite" , {
                text "30 damage"
                energyCost D
                onAttack{
                  damage 30
                }
            }
            move "Dark Fang" , {
                text "50 damage. Discard a random card from your opponent's hand."
                energyCost C,C
                onAttack{
                  damage 50
                  discardRandomCardFromOpponentsHand()
                }
            }
        };
        case ABSOL_87:
        return basic (this, hp:HP100, type:DARKNESS, retreatCost:1) {
            weakness FIGHTING
            resistance PSYCHIC, MINUS20
            bwAbility "Dark Ambition" , {
                text "As long as this Pokémon is in play, your opponent's Active Basic Pokémon's Retreat Cost is [C] more."
                getterA (GET_RETREAT_COST) {
      						if (it.effect.target.owner == self.owner.opposite && self.active) {
      							it.object += 1
      						}
                }
            }
            move "Shadow Seeker" , {
                text "30+ damage. This attack does 30 more damage for each [C] in your opponent’s Active Pokémon’s Retreat Cost."
                energyCost D,C,C
                onAttack{
                  damage 30 + 30*defending.retreatCost
                }
            }
        };
        case SPIRITOMB_88:
        return basic (this, hp:HP070, type:DARKNESS, retreatCost:1) {
            move "Spirit Compressor" , {
                text "Search your deck for up to 4 Pokémon and discard them. Then, shuffle your deck.\n"
                energyCost C
                attackRequirement{
                  assert my.deck : "There is no cards in your deck"
                }
                onAttack{
                  my.deck.search(max:4,"Choose up to 4 to discard",cardTypeFilter(POKEMON)).discard()
                  shuffleDeck()
                }
            }
            move "Spooky Shot" , {
                text "20 damage"
                energyCost C
            }
        };
        case ZORUA_89:
        return basic (this, hp:HP060, type:DARKNESS, retreatCost:1) {
            weakness FIGHTING
            resistance PSYCHIC, MINUS20
            move "Hide in Shadows" , {
                text "Switch this Pokémon with 1 of your Benched Pokémon."
                energyCost D
                attackRequirement{
                  assert my.bench : "There is no Pokémon on your bench"
                }
                onAttack{
                  sw self, my.bench.select("Choose the new active.")
                }
            }
        };
        case ZOROARK_90:
        return 	evolution (this, from:"Zorua", hp:HP110, type:DARKNESS, retreatCost:2) {
            weakness FIGHTING
            resistance PSYCHIC, MINUS20
            move "Taunt" , {
                text "Switch 1 of your opponent's Benched Pokémon with their Active Pokémon.\n"
                energyCost D
                attackRequirement{
                  assert opp.bench
                }
                onAttack{
                  sw defending, opp.bench.select("Choose the new active.")
                }
            }
            move "Night Punishment" , {
                text "20× damage. This attack does 20 damage for each Pokémon in your discard pile. You can't do more than 200 damage in this way."
                energyCost D,C,C
                onAttack{
                  damage Math.min(20*my.discard.filterByType(POKEMON),200)
                }
            }
        };
        case VULLABY_91:
        return basic (this, hp:HP060, type:DARKNESS, retreatCost:1) {
            weakness LIGHTNING
            resistance FIGHTING, MINUS20
            move "Collect" , {
                text "Draw a card.\n"
                energyCost C
                onAttack{
                  draw 1
                }
            }
            move "Corkscrew Punch" , {
                text "10 damage"
                energyCost D
                onAttack{
                  damage 10
                }
            }
        };
        case MANDIBUZZ_92:
        return 	evolution (this, from:"Vullaby", hp:HP120, type:DARKNESS, retreatCost:2) {
            weakness LIGHTNING
            resistance FIGHTING, MINUS20
            move "Trash Crash" , {
                text "Discard an Item card from your hand. If you do, this attack does 60 damage to 1 of your opponent's Pokémon. This attack's damage isn't affected by Weakness or Resistance.\n"
                energyCost D
                attackRequirement{
                  assert my.hand.filterByType(ITEM) : "There is no item in your hand"
                }
                onAttack{
                  my.hand.filterByType(ITEM).select("Choose the item to discard").discard()
                  noWrDamage(60,opp.all.select("Do 60 damage to?"))
                }
            }
            move "Brave Bird" , {
                text "120 damage. This Pokémon does 30 damage to itself."
                energyCost D,C,C
                onAttack{
                  damage 120
                  damage 30, self
                }
            }
        };
        case PANGORO_93:
        return 	evolution (this, from:"Pancham", hp:HP140, type:DARKNESS, retreatCost:4) {
            weakness FIGHTING
            resistance PSYCHIC, MINUS20
            move "Tighten Up" , {
                text "60 damage. Your opponent discards 2 cards from their hand.\n"
                energyCost D,C,C
                onAttack{
                  damage 60
                  afterDamage{
                    if(opp.hand){
                      opp.hand.oppSelect("Which card to discard?").discard()
                    }
                  }
                }
            }
            move "Tantrum" , {
                text "170 damage. This Pokémon is now Confused."
                energyCost D,D,C,C
                onAttack{
                  damage 170
                  apply CONFUSED, self
                }
            }
        };
        case YVELTAL_94:
        return basic (this, hp:HP110, type:DARKNESS, retreatCost:0) {
            weakness LIGHTNING
            resistance FIGHTING, MINUS20
            move "Derail" , {
                text "30 damage. Discard a Special Energy from your opponent's Active Pokémon.\n"
                energyCost D
                onAttack{
                  damage 30
                  discardDefendingSpecialEnergy(delegate)
                }
            }
            move "Clutch" , {
                text "60 damage. The Defending Pokémon can't retreat during your opponent's next turn."
                energyCost D,D
                onAttack{
                  damage 60
                  cantRetreat(defending)
                }
            }
        };
        case HOOPA_GX_95:
        return basic (this, hp:HP190, type:DARKNESS, retreatCost:3) {
            weakness FIGHTING
            resistance PSYCHIC, MINUS20
            move "Rogue Ring" , {
                text "Search your deck for up to 2 cards and put them into your hand. Then, shuffle your deck.\n"
                energyCost D
                attackRequirement{
                  assert my.deck : "There is no card in your deck"
                }
                onAttack{
                  my.deck.search(max:2,"Choose 2 card to put in your hand",{true}).moveTo(my.hand)
                }
            }
            move "Dark Strike" , {
                text "160 damage. This Pokémon can't use Dark Strike during your next turn.\n"
                energyCost D,D,D
                onAttack{
                  damage 160
                  cantUseAttack(thisMove, self)
                }
            }
            move "Devilish Hands GX" , {
                text "Choose 1 of your opponent's Pokémon-GX or Pokémon-EX 6 times. (You can choose the same Pokémon more than once.) For each time you chose a Pokémon, do 30 damage to it. This damage isn't affected by Weakness or Resistance. (You can't use more than 1 GX attack in a game.)\nPokémon-GX rule: When your Pokémon-GX is Knocked Out, your opponent takes 2 Prize cards."
                energyCost D,D,D
                attackRequirement{
                  gxCheck()
                  assert opp.all.findAll{it.cardTypes.is(POKEMON_GX) || it.cardTypes.is(POKEMON_EX)} : "your opponent does not have any Pokémon-GX or Pokémon-EX"
                }
                onAttack{
                  gxPerform()
                  def tar = opp.all.findAll{it.cardTypes.is(POKEMON_GX) || it.cardTypes.is(POKEMON_EX)}
                  def maxSel = Math.max(6,tar.size())
                  tar.select(count:maxSel).each{
                    noWrDamage(30,it)
                  }
                }
            }
        };
        case INCINEROAR_GX_96:
        return 	evolution (this, from:"Torracat", hp:HP250, type:DARKNESS, retreatCost:3) {
            weakness FIGHTING
            resistance PSYCHIC, MINUS20
            bwAbility "Scar Charge" , {
                text "Once during your turn (before your attack), you may put 3 damage counters on this Pokémon. If you do, search your deck for up to 3 [D] Energy cards and attach them to this Pokémon. Then, shuffle your deck."
                attackRequirement{
                  assert my.deck : "There is no more cards in your deck"
                }
                onAttack{
                  directDamage(30,self)
                  afterDamage{
                    my.deck.search(max:3,"Choose up to 3 [D] Energy cards", {it.cardTypes.is(ENERGY) && it.asEnergyCard.containsTypePlain(D)})
                  }
                }
            }
            move "Crushing Punch" , {
                text "130 damage. Discard a Special Energy from your opponent's Active Pokémon.\n"
                energyCost C,C,C
                onAttack{
                  damage 130
                  discardDefendingSpecialEnergy()
                }
            }
            move "Darkest Tornado GX" , {
                text "10+ damage. This attack does 50 more damage for each damage counter on this Pokémon. (You can't use more than 1 GX attack in a game.)\nPokémon-GX rule: When your Pokémon-GX is Knocked Out, your opponent takes 2 Prize cards."
                energyCost C,C,C
                attackRequirement{
                  gxCheck()
                }
                onAttack{
                  gxPerform()
                  damage 10+50*self.numberOfDamageCounters
                }
            }
        };
        case SKARMORY_97:
        return basic (this, hp:HP110, type:METAL, retreatCost:1) {
            weakness LIGHTNING
            resistance FIGHTING, MINUS20
            move "Calm Strike" , {
                text "20+ damage. If you have used your GX attack, this attack does 70 more damage.\n"
                energyCost M,C
                onAttack{
                  damage 20
                  if(bg.em().retrieveObject("gx_"+my.owner)) damage 70
                }
            }
            move "Steel Wing" , {
                text "90 damage. During your opponent's next turn, this Pokémon takes 30 less damage from attacks (after applying Weakness and Resistance)."
                energyCost M,M,C
                onAttack{
                  damage 90
                  reduceDamageNextTurn(hp(30),thisMove)
                }
            }
        };
        case JIRACHI_98:
        return basic (this, hp:HP070, type:METAL, retreatCost:1) {
            weakness FIRE
            resistance PSYCHIC, MINUS20
            bwAbility "Stellar Wish" , {
                text "Once during your turn (before your attack), if this Pokémon is your Active Pokémon, you may look at the top 5 cards of your deck, reveal a Trainer card you find there, and put it into your hand. Then, shuffle the other cards back into your deck, and this Pokémon is now Asleep."
                actionA{
                  checkLastTurn()
                  assert self.active : "$self is not your active Pokémon"
                  assert my.deck : "There is no more card in your deck"
                  powerUsed()
                  my.deck.subList(0,5).showToMe("The top 5 cards of your deck")
                  if(my.deck.subList(0,5).filterByType(TRAINER_CARD)){
                    my.deck.subList(0,5).filterByType(TRAINER_CARD).select("Choose the card to put in your hand").showToOpponent("Selected trainer card").moveTo(my.hand)
                  }
                  shuffleDeck()
                  apply ASLEEP, self
                }
            }
            move "Slap" , {
                text "30 damage."
                energyCost M,C
                onAttack{
                  damage 30
                }
            }
        };
        case BRONZOR_99:
        return basic (this, hp:HP050, type:METAL, retreatCost:1) {
            weakness FIGHTING
            resistance PSYCHIC, MINUS20
            bwAbility "Evolutionary Advantage" , {
                text "If you go second, this Pokémon can evolve during your first turn."
                delayedA {
      					  before PREVENT_EVOLVE, self, null, EVOLVE_STANDARD, {
      					    if(bg.turnCount == 2) prevent()
      					  }
      					}
            }
            move "Tackle" , {
                text "20 damage."
                energyCost M,C
                onAttack{
                  damage 20
                }
            }
        };
        case BRONZONG_100:
        return 	evolution (this, from:"Bronzor", hp:HP130, type:METAL, retreatCost:3) {
            weakness FIRE
            resistance PSYCHIC, MINUS20
            bwAbility "Heatproof" , {
                text "Prevent all damage done to this Pokémon by attacks from your opponent's [R] Pokémon."
                delayedA{
                  before APPLY_ATTACK_DAMAGES, {
    					      bg.dm().each {
    					        if(it.to == self && it.from.types.contains(R) && it.from.owner == self.owner.opposite && it.dmg.value && it.notNoEffect) {
    					          bc "Heatproof prevents damage from [R] Pokémon"
    					          it.dmg = hp(0)
    					        }
    					      }
    					    }
                }
            }
            move "Shady Stamp" , {
                text "70 damage. Your opponent's Active Pokémon is now Confused."
                energyCost M,C,C
                onAttack{
                  damage 70
                  afterDamage{
                    apply CONFUSED
                  }
                }
            }
        };
        case FERROSEED_101:
        return basic (this, hp:HP060, type:METAL, retreatCost:3) {
            weakness FIRE
            resistance PSYCHIC, MINUS20
            move "Continuous Tumble" , {
                text "20× damage. Flip a coin until you get tails. This attack does 20 damage for each heads."
                energyCost M
                onAttack{
                  flipUntilTails {damage 20}
                }
            }
        };
        case FERROTHORN_102:
        return 	evolution (this, from:"Ferroseed", hp:HP120, type:METAL, retreatCost:3) {
            weakness FIRE
            resistance PSYCHIC, MINUS20
            move "Guard Press" , {
                text "20 damage. During your opponent's next turn, this Pokémon takes 20 less damage from attacks (after applying Weakness and Resistance).\n"
                energyCost M
                onAttack{
                  damage 20
                  reduceDamageNextTurn(hp(20),thisMove)
                }
            }
            move "Thorn Pod Throw" , {
                text "80 damage. This attack does 20 damage times the amount of  [M] Energy attached to this Pokémon to 1 of your opponent’s Benched Pokémon. You can’t do more than 100 damage to a Benched Pokémon in this way. "
                energyCost C,C,C
                onAttack{
                  damage 80
                  def addDmg = 20*Math.min(self.cards.energyCount(M),5)
                  damage addDmg
                }
            }
        };
        case PAWNIARD_103:
        return basic (this, hp:HP070, type:METAL, retreatCost:1) {
            weakness FIRE
            resistance PSYCHIC, MINUS20
            move "Rigidify" , {
                text "During your opponent's next turn, this Pokémon takes 30 less damage from attacks (after applying Weakness and Resistance).\n"
                energyCost M
                onAttack{
                  reduceDamageNextTurn(hp(30),thisMove)
                }
            }
            move "Scratch" , {
                text "20 damage"
                energyCost C,C
                onAttack{
                  damage 20
                }
            }
        };
        case BISHARP_104:
        return 	evolution (this, from:"Pawniard", hp:HP110, type:METAL, retreatCost:2) {
            weakness FIRE
            resistance PSYCHIC, MINUS20
            move "Single Lunge" , {
                text "30+ damage. If this Pokémon has no damage counters on it, this attack does 90 more damage.\n"
                energyCost M
                onAttack{
                  damage 30
                  if(self.numberOfDamageCounters == 0) damage 90
                }
            }
            move "Power Edge" , {
                text "90 damage"
                energyCost M,C,C
                onAttack{
                  damage 90
                }
            }
        };
        case COBALION_GX_105:
        return basic (this, hp:HP170, type:METAL, retreatCost:1) {
            weakness FIRE
            resistance PSYCHIC, MINUS20
            bwAbility "Metal Symbol" , {
                text "Each of your Pokémon that has any [M] Energy attached to it can't be affected by any Special Conditions. Remove any Special Conditions affecting those Pokémon."
                def verdantWind={
                  for(pcs in all){
                    if(pcs.specialConditions && pcs.owner==self.owner && pcs.cards.energyCount(M)){
                      bc "Metal Symbol clears special conditions"
                      clearSpecialCondition(pcs, SRC_ABILITY)
                    }
                  }
                }
                delayedA {
                  after ATTACH_ENERGY, {
                    verdantWind()
                  }
                  after ENERGY_SWITCH, {
                    verdantWind()
                  }
                  before APPLY_SPECIAL_CONDITION, {
                    def pcs=e.getTarget(bg)
                    if(pcs.owner==self.owner && pcs.cards.energyCount(M)){
                      bc "Metal Symbol prevents special conditions"
                      prevent()
                    }
                  }
                }
                onActivate {
                  verdantWind()
                }
            }
            move "Dueling Saber" , {
                text "50+ damage. If there is any Stadium card in play, this attack does 60 more damage.\n"
                energyCost M,M
                onAttack{
                  damage 50
                  if(bg.stadiumInfoStruct){
                    damage 60
                  }
                }
            }
            move "Iron Rule GX" , {
                text "During your opponent's next turn, none of your opponent's Pokémon can attack (including newly played Pokémon). (You can't use more than 1 GX attack in a game.)\nPokémon-GX rule: When your Pokémon-GX is Knocked Out, your opponent takes 2 Prize cards."
                energyCost C
                attackRequirement{
                  gxCheck()
                }
                onAttack{
                  gxPerform()
                  delayed{
                    before ATTACK_MAIN, {
                      bc "Iron Rule GX prevents you from attacking"
                      prevent()
                    }
                    unregisterAfter 2
                  }
                }
            }
        };
        case HONEDGE_106:
        return basic (this, hp:HP060, type:METAL, retreatCost:2) {
            weakness FIRE
            resistance PSYCHIC, MINUS20
            move "Cut Down" , {
                text "Flip a coin. If heads, discard an Energy from your opponent's Active Pokémon."
                energyCost M
                onAttack{
                  flip{discardDefendingEnergy()}
                }
            }
        };
        case DOUBLADE_107:
        return 	evolution (this, from:"Honedge", hp:HP090, type:METAL, retreatCost:2) {
            weakness FIRE
            resistance PSYCHIC, MINUS20
            move "Tool Drop" , {
                text "30× damage. This attack does 30 damage for each Pokémon Tool card attached to all Pokémon"
                energyCost C,C
                onAttack{
                  my.all.each{
                    if(it.cards.filterByType(POKEMON_TOOL)) damage 30
                  }
                  opp.all.each{
                    if(it.cards.filterByType(POKEMON_TOOL)) damage 30
                  }
                }
            }
        };
        case AEGISLASH_108:
        return 	evolution (this, from:"Doublade", hp:HP140, type:METAL, retreatCost:3) {
            weakness FIRE
            resistance PSYCHIC, MINUS20
            bwAbility "Royal Guard" , {
                text "This Pokémon takes 40 less damage from attacks (after applying Weakness and Resistance)."
                delayedA{
                  before APPLY_ATTACK_DAMAGES, {
                    bg.dm().each{
                    if(it.to == self && it.notNoEffect && it.dmg.value) {
                      bc "Royal Guard -40"
                      it.dmg -= hp(40)
                    }
                  }
                }
              }
            }
            move "Shield Bash" , {
                text "100 damage. This attack's damage isn't affected by any effects on your opponent's Active Pokémon."
                energyCost M,C,C
                onAttack{
                  shredDamage 100
                }
            }
        };
        case KLEFKI_109:
        return basic (this, hp:HP060, type:METAL, retreatCost:1) {
            weakness FIRE
            resistance PSYCHIC, MINUS20
            bwAbility "Key of Secrets" , {
                text "Each of your [M] Pokémon's Resistance is now –40."
                getter(GET_RESISTANCES) {holder->
                  if(holder.effect.target.types.contains(M) && holder.effect.target.owner == self.owner){
                    def newR=[]
                    for (Resistance r in holder.object){
                      def r2=r.copy()
                      r2.resistanceType = Resistance.ResistanceType.MINUS20
                      newR.add(r2)
                    }
                  }
                  holder.object=newR
                }
              }
            move "Ram" , {
                text "30 damage"
                energyCost M,C
                onAttack{
                  damage 30
                }
            }
        };
        case ALOLAN_NINETALES_110:
        return 	evolution (this, from:"Alolan Vulpix", hp:HP110, type:FAIRY, retreatCost:1) {
            weakness METAL
            bwAbility "Luminous Barrier" , {
                text "Prevent all effects of attacks, including damage, done to this Pokémon by your opponent's Pokémon-GX or Pokémon-EX."
                safeguardForExAndGx("Luminous Barrier", self, delegate)
            }
            move "Aurora Beam" , {
                text "80 damage"
                energyCost Y,C,C
                onAttack{
                  damage 80
                }
            }
        };
        case MIMIKYU_111:
        return basic (this, hp:HP070, type:FAIRY, retreatCost:1) {
          globalAbility {Card thisCard->
  					delayed (priority: LAST) {
  						after PROCESS_ATTACK_EFFECTS, {
  							if(ef.attacker.owner!=thisCard.player && !(ef as Attack).move.name.endsWith("-GX")){
  								bg.em().storeObject("MimiCopycatMove_${thisCard.hashCode()}", ef.move)
  								bg.em().storeObject("MimiCopycatTC_${thisCard.hashCode()}", bg.turnCount)
  							}
  						}
  					}
  				}
  				move "Filch", {
  					text "Draw 2 cards."
  					energyCost C
  					onAttack {
  						draw 2
  					}
  				}
  				move "Copycat", {
  					text "If your opponent's Pokémon used an attack that isn't a GX attack during their last turn, use it as this attack."
  					energyCost Y, C
  					attackRequirement {
  						def tc = bg.em().retrieveObject("MimiCopycatTC_${self.topPokemonCard.hashCode()}") ?: -1
  						assert tc+1 == bg.turnCount : "Opponent did not used a valid move last turn"
  					}
  					onAttack {
  						def lastMove = bg.em().retrieveObject("MimiCopycatMove_${self.topPokemonCard.hashCode()}") as Move
  						def bef=blockingEffect(ENERGY_COST_CALCULATOR, BETWEEN_TURNS)
  						bc "Copycat copies ${lastMove.name}"
  						attack (lastMove)
  						bef.unregisterItself(bg().em())
  					}
  				}
        };
        case LATIAS_LATIOS_GX_112:
        return basic (this, hp:HP250, type:DRAGON, retreatCost:1) {
            weakness FAIRY
            move "Buster Purge" , {
                text "240 Discard 3 Energy from this Pokémon."
                energyCost W,P,P,C
                onAttack{
                  damage 240
                  afterDamage{
                    discardSelfEnergy C,C,C
                  }
                }
            }
            move "Aero Unit GX" , {
                text "Attach 5 basic Energy cards from your discard pile to your Pokémon in any way you like. If this Pokémon has at least 1 extra Energy attached to it (in addition to this attack's cost), prevent all effects of attacks, including damage, done to it during your opponent's next turn. (You can't use more than 1 GX attack in a game.)\nTAG TEAM rule: When your TAG TEAM is Knocked Out, your opponent takes 3 Prize cards."
                energyCost P
                attackRequirement{
                  gxCheck()
                }
                onAttack{
                  gxPerform()
                  attachEnergyFrom(my.discard,my.all)
                  attachEnergyFrom(my.discard,my.all)
                  attachEnergyFrom(my.discard,my.all)
                  attachEnergyFrom(my.discard,my.all)
                  attachEnergyFrom(my.discard,my.all)
                  if(self.cards.energySufficient(thisMove.energyCost() + C)){
                    preventAllEffectsNextTurn()
                  }
                }
            }
        };
        case ALOLAN_EXEGGUTOR_113:
        return copy (ForbiddenLight.ALOLAN_EXEGGUTOR_2, this);
        case ALOLAN_EXEGGUTOR_114:
        return 	evolution (this, from:"Exeggcute", hp:HP160, type:DRAGON, retreatCost:4) {
            weakness FAIRY
            move "Paradise Draw" , {
                text "You may discard any number of cards from your hand. Then, draw cards until you have 6 cards in your hand.\n"
                onAttack{
                  if(my.hand){
                    my.hand.select(max:my.hand.size(),"Choose the cards to discard").discard()
                    draw 6-my.hand.size()
                  }
                }
            }
            move "Egg Splat" , {
                text "60× damage. Discard any number of Exeggcute from your hand. This attack does 60 damage for each card you discarded in this way."
                energyCost G,C
                attackRequirement{
                  assert my.hand.filterByType(POKEMON).findAll{it.name == "Exeggcute"} : "There is no Exeggcute in your hand"
                }
                onAttack{
                  def tar = my.hand.filterByType(POKEMON).findAll{it.name == "Exeggcute"}
                  damage 60*tar.select(max:tar.size(),"Choose the Exeggcute to discard").discard().size()
                }
            }
        };
        case DRATINI_115:
        return basic (this, hp:HP060, type:DRAGON, retreatCost:2) {
            weakness FAIRY
            move "Dragon Rage" , {
                text "60 damage. Flip 2 coins. If either of them is tails, this attack does nothing."
                energyCost L
                onAttack{
                  flip 2,{},{},[2:{damage 60},1:bc "$thisMove failed",0:bc "$thisMove failed"]
                }
            }
        };
        case DRATINI_116:
        return basic (this, hp:HP060, type:DRAGON, retreatCost:2) {
            weakness FAIRY
            bwAbility "Defensive Scales" , {
                text "Prevent all effects of your opponent's attacks, except damage, done to this Pokémon."
                delayedA {
      		        before null, null, ATTACK, {
      		            if(ef instanceof TargetedEffect && bg.currentTurn==self.owner.opposite && ef.effectType != DAMAGE){
      		                def pcs = (ef as TargetedEffect).getResolvedTarget(bg, e)
      		                if(pcs != null && pcs.owner == self.owner){
      		                    bc "Defensive Scales prevents all effects done to $self"
      		                    prevent()
      		                }
      		            }
      		        }
      					}
            }
            move "Rain Splash" , {
                text "10 damage"
                energyCost W
                onAttack{
                  damage 10
                }
            }
        };
        case DRAGONAIR_117:
        return 	evolution (this, from:"Dratini", hp:HP090, type:DRAGON, retreatCost:2) {
            weakness FAIRY
            move "Twister" , {
                text "30 damage. Flip 2 coins. For each heads, discard an Energy from your opponent's Active Pokémon. If both of them are tails, this attack does nothing."
                energyCost W,L
                onAttack{
                  flip 2,{},{},[2:{damage 30;
                      afterDamage{
                        discardDefendingEnergy()
                        discardDefendingEnergy()
                      }
                    },1:{
                      damage 30;
                      afterDamage{
                        discardDefendingEnergy()
                      }
                    },0:{
                      bc "$thisMove failed"
                      }]
                }
            }
        };
        case DRAGONITE_118:
        return 	evolution (this, from:"Dragonair", hp:HP160, type:DRAGON, retreatCost:3) {
            weakness FAIRY
            bwAbility "Fast Call" , {
                text "Once during your turn (before your attack), you may search your deck for a Supporter card, reveal it, and put it into your hand. Then, shuffle your deck."
                actionA{
                  checkLastTurn()
                  assert my.deck : "There is no more card in your deck"
                  powerUsed()
                  my.deck.search(count:1,"Choose a Supporter card",cardTypeFilter(SUPPORTER)).showToOpponent("Chosen card").moveTo(my.hand)
                }
            }
            move "Dragon Claw" , {
                text "120 damage"
                energyCost W,L,C
                onAttack{
                  damage 120
                }
            }
        };
        case EEVEE_SNORLAX_GX_119:
        return basic (this, hp:HP270, type:COLORLESS, retreatCost:4) {
            weakness FIGHTING
            move "Dump Truck Press" , {
                text "120+ damage. If your opponent's Active Pokémon is an Evolution Pokémon, this attack does 120 more damage.\n"
                energyCost C,C,C,C
            }
            move "Megaton Friends GX" , {
                text "210 damage. If this Pokémon has at least 1 extra Energy attached to it (in addition to this attack's cost), draw cards until you have 10 cards in your hand. (You can't use more than 1 GX attack in a game.)\nTAG TEAM rule: When your TAG TEAM is Knocked Out, your opponent takes 3 Prize cards."
                energyCost C,C,C,C
            }
        };
        case PIDGEY_120:
        return basic (this, hp:HP050, type:COLORLESS, retreatCost:1) {
            weakness LIGHTNING
            resistance FIGHTING, MINUS20
            move "Collect" , {
                text "Draw a card.\n"
                energyCost C
            }
            move "Gust" , {
                text "20 damage"
                energyCost C,C
            }
        };
        case PIDGEY_121:
        return basic (this, hp:HP060, type:COLORLESS, retreatCost:1) {
            weakness LIGHTNING
            resistance FIGHTING, MINUS20
            move "Quick Attack" , {
                text "10+ damage. Flip a coin. If heads, this attack does 10 more damage."
                energyCost C
            }
        };
        case PIDGEOTTO_122:
        return 	evolution (this, from:"Pidgey", hp:HP060, type:COLORLESS, retreatCost:1) {
            weakness LIGHTNING
            resistance FIGHTING, MINUS20
            bwAbility "Air Mail" , {
                text "Once during your turn (before your attack), you may look at the top 2 cards of your deck and put 1 of them into your hand. Put the other card on the bottom of your deck."
            }
            move "Gust" , {
                text "30 damage"
                energyCost C,C
            }
        };
        case PIDGEOT_123:
        return 	evolution (this, from:"Pidgeotto", hp:HP130, type:COLORLESS, retreatCost:0) {
            weakness LIGHTNING
            resistance FIGHTING, MINUS20
            move "Whirlwind" , {
                text "60 damage. Your opponent switches their Active Pokémon with 1 of their Benched Pokémon.\n"
                energyCost C,C
            }
            move "Spin Storm" , {
                text "Put your opponent's Active Pokémon and all cards attached to it into your opponent's hand."
                energyCost C,C,C
            }
        };
        case MEOWTH_124:
        return basic (this, hp:HP070, type:COLORLESS, retreatCost:1) {
            weakness FIGHTING
            move "Scratch" , {
                text "10 damage"
                energyCost C
            }
            move "Bite" , {
                text "20 damage"
                energyCost C,C
            }
        };
        case PERSIAN_125:
        return 	evolution (this, from:"Meowth", hp:HP100, type:COLORLESS, retreatCost:1) {
            weakness FIGHTING
            move "Make &#8216;Em Pay" , {
                text "20 damage. If your opponent has 4 or more cards in their hand, they reveal their hand. Discard cards you find there until your opponent has exactly 4 cards in their hand.\n"
                energyCost C
            }
            move "Sharp Claws" , {
                text "30+ damage. Flip a coin. If heads, this attack does 60 more damage."
                energyCost C,C
            }
        };
        case FARFETCHD_126:
        return basic (this, hp:HP080, type:COLORLESS, retreatCost:1) {
            weakness LIGHTNING
            resistance FIGHTING, MINUS20
            move "Collect" , {
                text "Draw 2 cards.\n"
                energyCost C
            }
            move "Tool Buster" , {
                text "20+ damage. Before doing damage, discard all Pokémon Tool cards from your opponent's Active Pokémon. If you discarded a Pokémon Tool card in this way, this attack does 70 more damage."
                energyCost C
            }
        };
        case KANGASKHAN_127:
        return basic (this, hp:HP130, type:COLORLESS, retreatCost:2) {
            weakness FIGHTING
            move "Fast Evolution" , {
                text "Search your deck for up to 2 Evolution cards, reveal them, and put them into your hand. Then, shuffle your deck.\n"
                energyCost C
            }
            move "Mega Punch" , {
                text "80 damage"
                energyCost C,C,C
            }
        };
        case TAUROS_128:
        return basic (this, hp:HP130, type:COLORLESS, retreatCost:2) {
            weakness FIGHTING
            move "Raging Herd" , {
                text "10+ damage. This attack does 10 more damage for each damage counter on all of your Tauros and Tauros-GX."
                energyCost C,C
            }
        };
        case AERODACTYL_129:
        return 	evolution (this, from:"Unidentified Fossil", hp:HP130, type:COLORLESS, retreatCost:1) {
            weakness LIGHTNING
            resistance FIGHTING, MINUS20
            move "Supersonic" , {
                text "Your opponent's Active Pokémon is now Confused.\n"
                energyCost C
            }
            move "Fossil Fangs" , {
                text "90+ damage. If you don't have any Pokémon-GX or Pokémon-EX on your Bench, this attack does 90 more damage."
                energyCost C,C,C
            }
        };
        case LUGIA_130:
        return basic (this, hp:HP130, type:COLORLESS, retreatCost:2) {
            weakness LIGHTNING
            resistance FIGHTING, MINUS20
            move "Power Charger" , {
                text "30 damage. Search your deck for a basic Energy card and attach it to this Pokémon. Then, shuffle your deck.\n"
                energyCost C
            }
            move "Blasting Wind" , {
                text "110 damage"
                energyCost C,C,C,C
            }
        };
        case ZANGOOSE_131:
        return basic (this, hp:HP100, type:COLORLESS, retreatCost:1) {
            weakness FIGHTING
            move "Head Hunt" , {
                text "Look at the top 6 cards of your deck, reveal any number of Pokémon you find there, and put them into your hand. Discard the other cards.\n"
                energyCost C
            }
            move "Slash" , {
                text "40 damage"
                energyCost C,C
            }
        };
        case BILLS_ANALYSIS_132:
        return supporter(this) {
                text "Look at the top 7 cards of your deck. You may reveal up to 2 Trainer cards you find there and put them into your hand. Shuffle the other cards back into your deck.\nYou may play only 1 Supporter card during your turn (before your attack)."
        };
        case BLACK_MARKET_PRISM_STAR_133:
        return trainer(this) {
                text "Whenever any player's [D] Pokémon with any [D] Energy attached to it is Knocked Out by damage from an opponent's attack, that opponent takes 1 less Prize card.\nWhenever any player plays an Item or Supporter card from their hand, prevent all effects of that card done to this Stadium card.\nThis card stays in play when you play it. Discard this card if another Stadium card comes into play. If another card with the same name is in play, you can't play this card.\nPrism Star Rule: You can't have more than 1 Prism Star card with the same name in your deck. If a Prism Star card would go to the discard pile, put it in the Lost Zone instead."
        };
        case BROCKS_GRIT_134:
        return supporter(this) {
                text "Shuffle 6 in any combination of Pokémon and basic Energy cards from your discard pile into your deck.\nYou may play only 1 Supporter card during your turn (before your attack)."
        };
        case BUFF_PADDING_135:
        return itemCard (this) {
                text "Attach a Pokémon Tool to 1 of your Pokémon that doesn't already have a Pokémon Tool attached to it.\nIf the Retreat Cost of the Pokémon this card is attached to is 4, that Pokémon gets +50 HP.\nYou may play as many Item cards as you like during your turn (before your attack)."
        };
        case DANA_136:
        return supporter(this) {
                text "You can play this card only if your opponent's Active Pokémon is a Stage 2 Pokémon. Search your deck for up to 2 cards and put them into your hand. Then, shuffle your deck.\nYou may play only 1 Supporter card during your turn (before your attack)."
        };
        case DANGEROUS_DRILL_137:
        return itemCard (this) {
                text "You can play this card only if you discard a [D] Pokémon from your hand.\nDiscard a Pokémon Tool or Special Energy card from 1 of your opponent's Pokémon, or discard any Stadium card in play.\nYou may play as many Item cards as you like during your turn (before your attack)."
        };
        case ELECTROCHARGER_138:
        return itemCard (this) {
                text "Flip 2 coins. For each heads, shuffle an Electropower from your discard pile into your deck.\nYou may play as many Item cards as you like during your turn (before your attack)."
        };
        case ERIKAS_HOSPITALITY_139:
        return supporter(this) {
                text "You can play this card only if you have 4 or fewer other cards in your hand.\nDraw a card for each of your opponent's Pokémon in play.\nYou may play only 1 Supporter card during your turn (before your attack)."
        };
        case EVELYN_140:
        return supporter(this) {
                text "You can play this card only if your opponent's Active Pokémon is a Stage 1 Pokémon.\nDraw 4 cards.\nYou may play only 1 Supporter card during your turn (before your attack)."
        };
        case FAIRY_CHARM_UB_141:
        return itemCard (this) {
                text "Attach a Pokémon Tool to 1 of your Pokémon that doesn't already have a Pokémon Tool attached to it.\nPrevent all damage done to the [Y] Pokémon this card is attached to by attacks from your opponent's Ultra Beast Pokémon-GX and Ultra Beast Pokémon-EX.\nYou may play as many Item cards as you like during your turn (before your attack)."
        };
        case GRASS_MEMORY_142:
        return itemCard (this) {
                text "Attach a Pokémon Tool to 1 of your Pokémon that doesn't already have a Pokémon Tool attached to it.\nThe Silvally-GX this card is attached to is a [G] Pokémon.\nYou may play as many Item cards as you like during your turn (before your attack)."
        };
        case INGO_EMMET_143:
        return supporter(this) {
                text "Look at the top card of your deck, and then choose 1:Discard your hand and draw 5 cards.Discard your hand and draw 5 cards from the bottom of your deck.\nYou may play only 1 Supporter card during your turn (before your attack)."
        };
        case JASMINE_144:
        return supporter(this) {
                text "Search your deck for a [M] Pokémon, reveal it, and put it into your hand. If you go second and it's your first turn, search for 5 [M] Pokémon instead of 1. Then, shuffle your deck.\nYou may play only 1 Supporter card during your turn (before your attack)."
        };
        case JUDGE_WHISTLE_145:
        return itemCard (this) {
                text "Choose 1:Draw a card.Put a Judge card from your discard pile into your hand.\nYou may play as many Item cards as you like during your turn (before your attack)."
        };
        case LAVENDER_TOWN_146:
        return stadium(this) {
                text "Once during each player's turn, that player may look at their opponent's hand.\nThis card stays in play when you play it. Discard this card if another Stadium card comes into play. If another card with the same name is in play, you can't play this card."
        };
        case METAL_GOGGLES_147:
        return itemCard (this) {
                text "Attach a Pokémon Tool to 1 of your Pokémon that doesn't already have a Pokémon Tool attached to it.\nThe [M] Pokémon this card is attached to takes 30 less damage from your opponent's attacks (after applying Weakness and Resistance), and your opponent's attacks and Abilities can't put damage counters on it.\nYou may play as many Item cards as you like during your turn (before your attack)."
        };
        case MORGAN_148:
        return supporter(this) {
                text "You can play this card only if you discard Dana, Evelyn, and Nita from your hand.\nLook at the top 12 cards of your deck and attach any number of Energy cards you find there to your Pokémon in any way you like. Shuffle the other cards back into your deck.\nYou may play only 1 Supporter card during your turn (before your attack)."
        };
        case NANU_149:
        return supporter(this) {
                text "Choose a Basic [D] Pokémon in your discard pile. Switch it with 1 of your Pokémon in play. Any attached cards, damage counters, Special Conditions, turns in play, and any other effects remain of the new Pokémon.\nYou may play only 1 Supporter card during your turn (before your attack)."
        };
        case NITA_150:
        return supporter(this) {
                text "You can play this card only if your opponent's Active Pokémon is a Basic Pokémon.\nPut an Energy from your opponent's Active Pokémon on top of their deck.\nYou may play only 1 Supporter card during your turn (before your attack)."
        };
        case POKéMON_COMMUNICATION_151:
        return itemCard (this) {
                text "Reveal a Pokémon from your hand and put it into your deck. If you do, search your deck for a Pokémon, reveal it, and put it into your hand. Then, shuffle your deck.\nYou may play as many Item cards as you like during your turn (before your attack)."
        };
        case RETURN_LABEL_152:
        return itemCard (this) {
                text "Put a card from your opponent's discard pile on the bottom of their deck.\nYou may play as many Item cards as you like during your turn (before your attack)."
        };
        case SABRINAS_SUGGESTION_153:
        return supporter(this) {
                text "Your opponent reveals their hand. You may choose a Supporter card you find there and use the effect of that card as the effect of this card.\nYou may play only 1 Supporter card during your turn (before your attack)."
        };
        case UNIDENTIFIED_FOSSIL_154:
        return itemCard (this) {
                text "Play this card as if it were a 60-HP [C] Basic Pokémon. At any time during your turn (before your attack), you may discard this card from play.\nThis card can't retreat.\nYou may play as many Item cards as you like during your turn (before your attack)."
        };
        case VIRIDIAN_FOREST_155:
        return stadium(this) {
                text "Once during each player's turn, that player may discard a card from their hand. If they do, that player searches their deck for a basic Energy card, reveals it, and puts it into their hand. Then, that player shuffles their deck\nThis card stays in play when you play it. Discard this card if another Stadium card comes into play. If another card with the same name is in play, you can't play this card."
        };
        case WATER_MEMORY_156:
        return itemCard (this) {
                text "Attach a Pokémon Tool to 1 of your Pokémon that doesn't already have a Pokémon Tool attached to it.\nThe Silvally-GX this card is attached to is a [W] Pokémon.\nYou may play as many Item cards as you like during your turn (before your attack)."
        };
        case WONDROUS_LABYRINTH_PRISM_STAR_157:
        return trainer(this) {
                text "The attacks of non-[Y] Pokémon (both yours and your opponent's) cost [C] more.\nWhenever any player plays an Item or Supporter card from their hand, prevent all effects of that card done to this Stadium card.\nThis card stays in play when you play it. Discard this card if another Stadium card comes into play. If another card with the same name is in play, you can't play this card.\nPrism Star Rule: You can't have more than 1 Prism Star card with the same name in your deck. If a Prism Star card would go to the discard pile, put it in the Lost Zone instead."
        };
        case CELEBI_VENUSAUR_GX_158:
        return basic (this, hp:HP270, type:GRASS, retreatCost:4) {
            weakness FIRE
            move "Pollen Hazard" , {
                text "50 damage. Your opponent's Active Pokémon is now Burned, Confused, and Poisoned.\n"
                energyCost G,C,C
            }
            move "Solar Beam" , {
                text "150 damage"
                energyCost G,G,C,C
            }
            move "Evergreen GX" , {
                text "180 damage. Heal all damage from this Pokémon. If this Pokémon has at least 1 extra"
                energyCost G,G,C,C
            }
        };
        case MAGIKARP_WAILORD_GX_159:
        return basic (this, hp:HP300, type:WATER, retreatCost:4) {
            weakness GRASS
            move "Super Splash" , {
                text "180 damage"
                energyCost W,W,W,W,W
            }
            move "Towering Splash" , {
                text "10 damage. If this Pokémon has at least 7 extra"
                energyCost W
            }
        };
        case MAGIKARP_WAILORD_GX_160:
        return basic (this, hp:HP300, type:WATER, retreatCost:4) {
            weakness GRASS
            move "Super Splash" , {
                text "180 damage"
                energyCost W,W,W,W,W
            }
            move "Towering Splash" , {
                text "10 damage. If this Pokémon has at least 7 extra"
                energyCost W
            }
        };
        case PIKACHU_ZEKROM_GX_161:
        return basic (this, hp:HP240, type:LIGHTNING, retreatCost:3) {
            weakness FIGHTING
            resistance METAL, MINUS20
            move "Full Blitz" , {
                text "150 damage. Search your deck for up to 3"
                energyCost L,L,L
            }
            move "Tag Bolt GX" , {
                text "200 damage. If this Pokémon has at least 3 extra"
                energyCost L,L,L
            }
        };
        case AMPHAROS_GX_162:
        return 	evolution (this, from:"Flaaffy", hp:HP240, type:LIGHTNING, retreatCost:3) {
            weakness FIGHTING
            resistance METAL, MINUS20
            move "Power Charge" , {
                text "30 damage. Put all Electropower cards from your discard pile into your hand.\n"
                energyCost L
            }
            move "Impact Bolt" , {
                text "150 damage. Discard all"
                energyCost L,L
            }
            move "Electrical GX" , {
                text "Search your deck for up to 7 Pokémon, reveal them, and put them into your hand. Then, shuffle your deck. (You can't use more than 1 GX attack in a game.)\nPokémon-GX rule: When your Pokémon-GX is Knocked Out, your opponent takes 2 Prize cards."
                energyCost L
            }
        };
        case GENGAR_MIMIKYU_GX_163:
        return basic (this, hp:HP240, type:PSYCHIC, retreatCost:2) {
            weakness DARKNESS
            resistance FIGHTING, MINUS20
            move "Poltergeist" , {
                text "50× damage. Your opponent reveals their hand. This attack does 50 damage for each Trainer card you find there.\n"
                energyCost P,P
            }
            move "Horror House GX" , {
                text "Your opponent can't play any cards from their hand during their next turn. If this Pokémon has at least 1 extra"
                energyCost P
            }
        };
        case GENGAR_MIMIKYU_GX_164:
        return basic (this, hp:HP240, type:PSYCHIC, retreatCost:2) {
            weakness DARKNESS
            resistance FIGHTING, MINUS20
            move "Poltergeist" , {
                text "50× damage. Your opponent reveals their hand. This attack does 50 damage for each Trainer card you find there.\n"
                energyCost P,P
            }
            move "Horror House GX" , {
                text "Your opponent can't play any cards from their hand during their next turn. If this Pokémon has at least 1 extra"
                energyCost P
            }
        };
        case HOOPA_GX_165:
        return basic (this, hp:HP190, type:DARKNESS, retreatCost:3) {
            weakness FIGHTING
            resistance PSYCHIC, MINUS20
            move "Rogue Ring" , {
                text "Search your deck for up to 2 cards and put them into your hand. Then, shuffle your deck.\n"
                energyCost D
            }
            move "Dark Strike" , {
                text "160 damage. This Pokémon can't use Dark Strike during your next turn.\n"
                energyCost D,D,D
            }
            move "Devilish Hands GX" , {
                text "Choose 1 of your opponent's Pokémon-GX or Pokémon-EX 6 times. (You can choose the same Pokémon more than once.) For each time you chose a Pokémon, do 30 damage to it. This damage isn't affected by Weakness or Resistance. (You can't use more than 1 GX attack in a game.)\nPokémon-GX rule: When your Pokémon-GX is Knocked Out, your opponent takes 2 Prize cards."
                energyCost D,D,D
            }
        };
        case INCINEROAR_GX_166:
        return 	evolution (this, from:"Torracat", hp:HP250, type:DARKNESS, retreatCost:3) {
            weakness FIGHTING
            resistance PSYCHIC, MINUS20
            bwAbility "Scar Charge" , {
                text "Once during your turn (before your attack), you may put 3 damage counters on this Pokémon. If you do, search your deck for up to 3 [D] Energy cards and attach them to this Pokémon. Then, shuffle your deck."
            }
            move "Crushing Punch" , {
                text "130 damage. Discard a Special Energy from your opponent's Active Pokémon.\n"
                energyCost C,C,C
            }
            move "Darkest Tornado GX" , {
                text "10+ damage. This attack does 50 more damage for each damage counter on this Pokémon. (You can't use more than 1 GX attack in a game.)\nPokémon-GX rule: When your Pokémon-GX is Knocked Out, your opponent takes 2 Prize cards."
                energyCost C,C,C
            }
        };
        case COBALION_GX_167:
        return basic (this, hp:HP170, type:METAL, retreatCost:1) {
            weakness FIRE
            resistance PSYCHIC, MINUS20
            bwAbility "Metal Symbol" , {
                text "Each of your Pokémon that has any [M] Energy attached to it can't be affected by any Special Conditions. Remove any Special Conditions affecting those Pokémon."
            }
            move "Dueling Saber" , {
                text "50+ damage. If there is any Stadium card in play, this attack does 60 more damage.\n"
                energyCost M,M
            }
            move "Iron Rule GX" , {
                text "During your opponent's next turn, none of your opponent's Pokémon can attack (including newly played Pokémon). (You can't use more than 1 GX attack in a game.)\nPokémon-GX rule: When your Pokémon-GX is Knocked Out, your opponent takes 2 Prize cards."
                energyCost C
            }
        };
        case LATIAS_LATIOS_GX_168:
        return basic (this, hp:HP250, type:DRAGON, retreatCost:1) {
            weakness FAIRY
            move "Buster Purge" , {
                text "240 damage. Discard 3 Energy from this Pokémon.\n"
                energyCost W,P,P,C
            }
            move "Aero Unit GX" , {
                text "Attach 5 basic Energy cards from your discard pile to your Pokémon in any way you like. If this Pokémon has at least 1 extra Energy attached to it (in addition to this attack's cost), prevent all effects of attacks, including damage, done to it during your opponent's next turn. (You can't use more than 1 GX attack in a game.)\nTAG TEAM rule: When your TAG TEAM is Knocked Out, your opponent takes 3 Prize cards."
                energyCost P
            }
        };
        case LATIAS_LATIOS_GX_169:
        return basic (this, hp:HP250, type:DRAGON, retreatCost:1) {
            weakness FAIRY
            move "Buster Purge" , {
                text "240 damage. Discard 3 Energy from this Pokémon.\n"
                energyCost W,P,P,C
            }
            move "Aero Unit GX" , {
                text "Attach 5 basic Energy cards from your discard pile to your Pokémon in any way you like. If this Pokémon has at least 1 extra Energy attached to it (in addition to this attack's cost), prevent all effects of attacks, including damage, done to it during your opponent's next turn. (You can't use more than 1 GX attack in a game.)\nTAG TEAM rule: When your TAG TEAM is Knocked Out, your opponent takes 3 Prize cards."
                energyCost P
            }
        };
        case EEVEE_SNORLAX_GX_170:
        return basic (this, hp:HP270, type:COLORLESS, retreatCost:4) {
            weakness FIGHTING
            move "Dump Truck Press" , {
                text "120+ damage. If your opponent's Active Pokémon is an Evolution Pokémon, this attack does 120 more damage.\n"
                energyCost C,C,C,C
            }
            move "Megaton Friends GX" , {
                text "210 damage. If this Pokémon has at least 1 extra Energy attached to it (in addition to this attack's cost), draw cards until you have 10 cards in your hand. (You can't use more than 1 GX attack in a game.)\nTAG TEAM rule: When your TAG TEAM is Knocked Out, your opponent takes 3 Prize cards."
                energyCost C,C,C,C
            }
        };
        case BROCKS_GRIT_171:
        return supporter(this) {
                text "Shuffle 6 in any combination of Pokémon and basic Energy cards from your discard pile into your deck.\nYou may play only 1 Supporter card during your turn (before your attack)."
        };
        case DANA_172:
        return supporter(this) {
                text "You can play this card only if your opponent's Active Pokémon is a Stage 2 Pokémon. Search your deck for up to 2 cards and put them into your hand. Then, shuffle your deck.\nYou may play only 1 Supporter card during your turn (before your attack)."
        };
        case ERIKAS_HOSPITALITY_173:
        return supporter(this) {
                text "You can play this card only if you have 4 or fewer other cards in your hand.\nDraw a card for each of your opponent's Pokémon in play.\nYou may play only 1 Supporter card during your turn (before your attack)."
        };
        case EVELYN_174:
        return supporter(this) {
                text "You can play this card only if your opponent's Active Pokémon is a Stage 1 Pokémon.\nDraw 4 cards.\nYou may play only 1 Supporter card during your turn (before your attack)."
        };
        case INGO_EMMET_175:
        return supporter(this) {
                text "Look at the top card of your deck, and then choose 1:Discard your hand and draw 5 cards.Discard your hand and draw 5 cards from the bottom of your deck.\nYou may play only 1 Supporter card during your turn (before your attack)."
        };
        case JASMINE_176:
        return supporter(this) {
                text "Search your deck for a [M] Pokémon, reveal it, and put it into your hand. If you go second and it's your first turn, search for 5 [M] Pokémon instead of 1. Then, shuffle your deck.\nYou may play only 1 Supporter card during your turn (before your attack)."
        };
        case MORGAN_177:
        return supporter(this) {
                text "You can play this card only if you discrad Dana, Evelyn, and Nita from your hand.\nLook at the top 12 cards of your deck and attach any number of Energy cards you find there to your Pokémon in any way you like. Shuffle the other cards back into your deck.\nYou may play only 1 Supporter card during your turn (before your attack)."
        };
        case NANU_178:
        return supporter(this) {
                text "Choose a Basic [D] Pokémon in your discard pile. Switch it with 1 of your Pokémon in play. Any attached cards, damage counters, Special Conditions, turns in play, and any other effects remain of the new Pokémon.\nYou may play only 1 Supporter card during your turn (before your attack)."
        };
        case NITA_179:
        return supporter(this) {
                text "You can play this card only if your opponent's Active Pokémon is a Basic Pokémon.\nPut an Energy from your opponent's Active Pokémon on top of their deck.\nYou may play only 1 Supporter card during your turn (before your attack)."
        };
        case SABRINAS_SUGGESTION_180:
        return supporter(this) {
                text "Your opponent reveals their hand. You may choose a Supporter card you find there and use the effect of that card as the effect of this card.\nYou may play only 1 Supporter card during your turn (before your attack)."
        };
        case CELEBI_VENUSAUR_GX_181:
        return basic (this, hp:HP270, type:GRASS, retreatCost:4) {
            weakness FIRE
            move "Pollen Hazard" , {
                text "50 damage. Your opponent's Active Pokémon is now Burned, Confused, and Poisoned.\n"
                energyCost G,C,C
            }
            move "Solar Beam" , {
                text "150 damage"
                energyCost G,G,C,C
            }
            move "Evergreen GX" , {
                text "180 damage. Heal all damage from this Pokémon. If this Pokémon has at least 1 extra"
                energyCost G,G,C,C
            }
        };
        case MAGIKARP_WAILORD_GX_182:
        return basic (this, hp:HP300, type:WATER, retreatCost:4) {
            weakness GRASS
            move "Super Splash" , {
                text "180 damage"
                energyCost W,W,W,W,W
            }
            move "Towering Splash" , {
                text "10 damage. If this Pokémon has at least 7 extra"
                energyCost W
            }
        };
        case PIKACHU_ZEKROM_GX_183:
        return basic (this, hp:HP240, type:LIGHTNING, retreatCost:3) {
            weakness FIGHTING
            resistance METAL, MINUS20
            move "Full Blitz" , {
                text "150 damage. Search your deck for up to 3"
                energyCost L,L,L
            }
            move "Tag Bolt GX" , {
                text "200 damage. If this Pokémon has at least 3 extra"
                energyCost L,L,L
            }
        };
        case AMPHAROS_GX_184:
        return 	evolution (this, from:"Flaaffy", hp:HP240, type:LIGHTNING, retreatCost:3) {
            weakness FIGHTING
            resistance METAL, MINUS20
            move "Power Charge" , {
                text "30 damage. Put all Electropower cards from your discard pile into your hand.\n"
                energyCost L
            }
            move "Impact Bolt" , {
                text "150 damage. Discard all"
                energyCost L,L
            }
            move "Electrical GX" , {
                text "Search your deck for up to 7 Pokémon, reveal them, and put them into your hand. Then, shuffle your deck. (You can't use more than 1 GX attack in a game.)\nPokémon-GX rule: When your Pokémon-GX is Knocked Out, your opponent takes 2 Prize cards."
                energyCost L
            }
        };
        case GENGAR_MIMIKYU_GX_185:
        return basic (this, hp:HP240, type:PSYCHIC, retreatCost:2) {
            weakness DARKNESS
            resistance FIGHTING, MINUS20
            move "Poltergeist" , {
                text "50× damage. Your opponent reveals their hand. This attack does 50 damage for each Trainer card you find there.\n"
                energyCost P,P
            }
            move "Horror House GX" , {
                text "Your opponent can't play any cards from their hand during their next turn. If this Pokémon has at least 1 extra"
                energyCost P
            }
        };
        case HOOPA_GX_186:
        return basic (this, hp:HP190, type:DARKNESS, retreatCost:3) {
            weakness FIGHTING
            resistance PSYCHIC, MINUS20
            move "Rogue Ring" , {
                text "Search your deck for up to 2 cards and put them into your hand. Then, shuffle your deck.\n"
                energyCost D
            }
            move "Dark Strike" , {
                text "160 damage. This Pokémon can't use Dark Strike during your next turn.\n"
                energyCost D,D,D
            }
            move "Devilish Hands GX" , {
                text "Choose 1 of your opponent's Pokémon-GX or Pokémon-EX 6 times. (You can choose the same Pokémon more than once.) For each time you chose a Pokémon, do 30 damage to it. This damage isn't affected by Weakness or Resistance. (You can't use more than 1 GX attack in a game.)\nPokémon-GX rule: When your Pokémon-GX is Knocked Out, your opponent takes 2 Prize cards."
                energyCost D,D,D
            }
        };
        case INCINEROAR_GX_187:
        return 	evolution (this, from:"Torracat", hp:HP250, type:DARKNESS, retreatCost:3) {
            weakness FIGHTING
            resistance PSYCHIC, MINUS20
            bwAbility "Scar Charge" , {
                text "Once during your turn (before your attack), you may put 3 damage counters on this Pokémon. If you do, search your deck for up to 3 [D] Energy cards and attach them to this Pokémon. Then, shuffle your deck."
            }
            move "Crushing Punch" , {
                text "130 damage. Discard a Special Energy from your opponent's Active Pokémon.\n"
                energyCost C,C,C
            }
            move "Darkest Tornado GX" , {
                text "10+ damage. This attack does 50 more damage for each damage counter on this Pokémon. (You can't use more than 1 GX attack in a game.)\nPokémon-GX rule: When your Pokémon-GX is Knocked Out, your opponent takes 2 Prize cards."
                energyCost C,C,C
            }
        };
        case COBALION_GX_188:
        return basic (this, hp:HP170, type:METAL, retreatCost:1) {
            weakness FIRE
            resistance PSYCHIC, MINUS20
            bwAbility "Metal Symbol" , {
                text "Each of your Pokémon that has any [M] Energy attached to it can't be affected by any Special Conditions. Remove any Special Conditions affecting those Pokémon."
            }
            move "Dueling Saber" , {
                text "50+ damage. If there is any Stadium card in play, this attack does 60 more damage.\n"
                energyCost M,M
            }
            move "Iron Rule GX" , {
                text "During your opponent's next turn, none of your opponent's Pokémon can attack (including newly played Pokémon). (You can't use more than 1 GX attack in a game.)\nPokémon-GX rule: When your Pokémon-GX is Knocked Out, your opponent takes 2 Prize cards."
                energyCost C
            }
        };
        case LATIAS_LATIOS_GX_189:
        return basic (this, hp:HP250, type:DRAGON, retreatCost:1) {
            weakness FAIRY
            move "Buster Purge" , {
                text "240 damage. Discard 3 Energy from this Pokémon.\n"
                energyCost W,P,P,C
            }
            move "Aero Unit GX" , {
                text "Attach 5 basic Energy cards from your discard pile to your Pokémon in any way you like. If this Pokémon has at least 1 extra Energy attached to it (in addition to this attack's cost), prevent all effects of attacks, including damage, done to it during your opponent's next turn. (You can't use more than 1 GX attack in a game.)\nTAG TEAM rule: When your TAG TEAM is Knocked Out, your opponent takes 3 Prize cards."
                energyCost P
            }
        };
        case EEVEE_SNORLAX_GX_190:
        return basic (this, hp:HP270, type:COLORLESS, retreatCost:4) {
            weakness FIGHTING
            move "Dump Truck Press" , {
                text "120+ damage. If your opponent's Active Pokémon is an Evolution Pokémon, this attack does 120 more damage.\n"
                energyCost C,C,C,C
            }
            move "Megaton Friends GX" , {
                text "210 damage. If this Pokémon has at least 1 extra Energy attached to it (in addition to this attack's cost), draw cards until you have 10 cards in your hand. (You can't use more than 1 GX attack in a game.)\nTAG TEAM rule: When your TAG TEAM is Knocked Out, your opponent takes 3 Prize cards."
                energyCost C,C,C,C
            }
        };
        case DANGEROUS_DRILL_191:
        return itemCard (this) {
                text "You can play this card only if you discard a [D] Pokémon from your hand.\nDiscard a Pokémon Tool or Special Energy card from 1 of your opponent's Pokémon, or discard any Stadium card in play.\nYou may play as many Item cards as you like during your turn (before your attack)."
        };
        case ELECTROCHARGER_192:
        return itemCard (this) {
                text "Flip 2 coins. For each heads, shuffle an Electropower from your discard pile into your deck.\nYou may play as many Item cards as you like during your turn (before your attack)."
        };
        case JUDGE_WHISTLE_193:
        return itemCard (this) {
                text "Choose 1:Draw a card.Put a Judge card from your discard pile into your hand.\nYou may play as many Item cards as you like during your turn (before your attack)."
        };
        case METAL_GOGGLES_194:
        return itemCard (this) {
                text "Attach a Pokémon Tool to 1 of your Pokémon that doesn't already have a Pokémon Tool attached to it.\nThe [M] Pokémon this card is attached to takes 30 less damage from your opponent's attacks (after applying Weakness and Resistance), and your opponent's attacks and Abilities can't put damage counters on it.\nYou may play as many Item cards as you like during your turn (before your attack)."
        };
        default:
            return null;
    }
  }
}
