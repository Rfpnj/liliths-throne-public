package com.lilithsthrone.game.character.race;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.lilithsthrone.game.character.CharacterUtils;
import com.lilithsthrone.game.character.GameCharacter;
import com.lilithsthrone.game.character.attributes.Attribute;
import com.lilithsthrone.game.character.attributes.IntelligenceLevel;
import com.lilithsthrone.game.character.body.Body;
import com.lilithsthrone.game.character.body.Covering;
import com.lilithsthrone.game.character.body.Wing;
import com.lilithsthrone.game.character.body.abstractTypes.AbstractFaceType;
import com.lilithsthrone.game.character.body.types.BodyCoveringType;
import com.lilithsthrone.game.character.body.types.EarType;
import com.lilithsthrone.game.character.body.types.FaceType;
import com.lilithsthrone.game.character.body.types.HairType;
import com.lilithsthrone.game.character.body.types.HornType;
import com.lilithsthrone.game.character.body.types.LegType;
import com.lilithsthrone.game.character.body.types.PenisType;
import com.lilithsthrone.game.character.body.types.TailType;
import com.lilithsthrone.game.character.body.types.WingType;
import com.lilithsthrone.game.character.body.valueEnums.BodyMaterial;
import com.lilithsthrone.game.character.body.valueEnums.BodySize;
import com.lilithsthrone.game.character.body.valueEnums.CoveringModifier;
import com.lilithsthrone.game.character.body.valueEnums.CoveringPattern;
import com.lilithsthrone.game.character.body.valueEnums.CupSize;
import com.lilithsthrone.game.character.body.valueEnums.HairStyle;
import com.lilithsthrone.game.character.body.valueEnums.Height;
import com.lilithsthrone.game.character.body.valueEnums.HornLength;
import com.lilithsthrone.game.character.body.valueEnums.LegConfiguration;
import com.lilithsthrone.game.character.body.valueEnums.Muscle;
import com.lilithsthrone.game.character.body.valueEnums.PenetrationGirth;
import com.lilithsthrone.game.character.body.valueEnums.WingSize;
import com.lilithsthrone.game.character.effects.PerkCategory;
import com.lilithsthrone.game.character.gender.Gender;
import com.lilithsthrone.game.character.npc.misc.Elemental;
import com.lilithsthrone.game.dialogue.DialogueFlagValue;
import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.rendering.SVGImages;
import com.lilithsthrone.utils.SvgUtil;
import com.lilithsthrone.utils.Util;
import com.lilithsthrone.utils.Util.Value;
import com.lilithsthrone.utils.colours.Colour;
import com.lilithsthrone.utils.colours.PresetColour;
import com.lilithsthrone.world.AbstractWorldType;
import com.lilithsthrone.world.Season;
import com.lilithsthrone.world.WorldType;

/**
 * @since 0.1.91
 * @version 0.3.7.1
 * @author tukaima, Innoxia
 */
public enum Subspecies {

	// HUMAN:
	HUMAN(true,
			"statusEffects/race/raceHuman",
			"statusEffects/race/raceBackground",
			"human",
			"humans",
			"man",
			"woman",
			"men",
			"women",
			"human",
			"Humans have a much higher resistance to the arousing effects of the arcane than any other race.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 5f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_LUST, 2f)),
			null,
			"Concerning Humans",
			"Concerning Humans",
			"HUMAN_BASIC",
			"HUMAN_ADVANCED",
			Race.HUMAN,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 10),
					new Value<>(PerkCategory.ARCANE, 1)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 10),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 1)),
			PresetColour.RACE_HUMAN,
			SubspeciesPreference.FOUR_ABUNDANT,
			"A typical human.",
			Util.newHashMapOfValues(
					new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.FOUR_COMMON),
					new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), Util.newArrayListOfValues(
					SubspeciesFlag.HIDDEN_FROM_PREFERENCES)) {
	},

	// ANGEL:
	ANGEL(true,
			"statusEffects/race/raceAngel",
			"statusEffects/race/raceBackground",
			"angel",
			"angels",
			"angel",
			"angel",
			"angels",
			"angels",
			"angel",
			"As an angel, [npc.nameIsFull] highly resistant to the arousing effects of the arcane, and [npc.is] particularly adept at fighting demons."
					+ " [npc.Her] natural instinct to protect humans, however, leaves [npc.her] quite vulnerable to them...",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 15f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, -100f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_LUST, 50f),
					new Value<Attribute, Float>(Attribute.DAMAGE_DEMON, 50f),
					new Value<Attribute, Float>(Attribute.DAMAGE_HUMAN, -50f)),
			null,
			"The Protectors",
			"The Protectors",
			"ANGEL_BASIC",
			"ANGEL_ADVANCED",
			Race.ANGEL,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 0),
					new Value<>(PerkCategory.ARCANE, 5)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 0),
					new Value<>(PerkCategory.ARCANE, 2)),
			PresetColour.RACE_ANGEL,
			SubspeciesPreference.FOUR_ABUNDANT,
			"A typical angel.",
			Util.newHashMapOfValues(), Util.newArrayListOfValues(
					SubspeciesFlag.HIDDEN_FROM_PREFERENCES)) {
		@Override
		public String[] getHalfDemonName(GameCharacter character) {
			String[] names = new String[] {
					"fallen angel",
					"fallen angels",
					"fallen angel",
					"fallen angel",
					"fallen angels",
					"fallen angels"};
			
			if(character!=null && !character.getHalfDemonSubspecies().isNonBiped()) {
				names = new String[] {
					applyNonBipedNameChange(character, "fallen angel", false, false),
					applyNonBipedNameChange(character, "fallen angel", false, true),
					applyNonBipedNameChange(character, "fallen angel", false, false),
					applyNonBipedNameChange(character, "fallen angel", true, false),
					applyNonBipedNameChange(character, "fallen angel", false, true),
					applyNonBipedNameChange(character, "fallen angel", true, true)
				};
			}
			
			return names;
		}
	},

	// DEMON:
	ELDER_LILIN(false,
			"statusEffects/race/raceElderLilin",
			"statusEffects/race/raceBackground",
			"elder lilin",
			"elder lilin",
			"elder lilin",
			"elder lilin",
			"elder lilin",
			"elder lilin",
			"elder lilin",
			"[npc.NameIsFull] one of the seven elder lilin, and [npc.is] one of the most powerful beings in existence. [npc.She] can transform [npc.her] body into any form [npc.she] [npc.verb(desire)], and [npc.has] absolute mastery over the arcane.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 1000f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 1000f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 1000f),
					new Value<Attribute, Float>(Attribute.HEALTH_MAXIMUM, 1000f),
					new Value<Attribute, Float>(Attribute.MANA_MAXIMUM, 1000f)),
			Util.newArrayListOfValues(
					"[style.boldExcellent(Unlimited)] <b style='color: "+ PresetColour.TRANSFORMATION_GENERIC.toWebHexString()+ ";'> self-transformations</b>",
					"<b style='color: "+ PresetColour.GENERIC_GOOD.toWebHexString()+ ";'>Immune to race transformations</b>"),
			"Lilith's Spawn",
			"Lilith's Spawns",
			"ELDER_LILIN_BASIC",
			"ELDER_LILIN_ADVANCED",
			Race.DEMON,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 1)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 1)),
			PresetColour.RACE_LILIN,
			SubspeciesPreference.ONE_LOW,
			"One of the seven elder lilin.",
			Util.newHashMapOfValues(), Util.newArrayListOfValues(
					SubspeciesFlag.HIDDEN_FROM_PREFERENCES)) {
		@Override
		public void applySpeciesChanges(Body body) {
			body.setSubspeciesOverride(ELDER_LILIN);
		}
	},
	
	LILIN(false,
			"statusEffects/race/raceLilin",
			"statusEffects/race/raceBackground",
			"lilin",
			"lilin",
			"lilin",
			"lilin",
			"lilin",
			"lilin",
			"lilin",
			"[npc.Name] is a lilin, and as such is far more powerful than a regular demon. [npc.She] can transform [npc.her] body into any form [npc.she] desires, and has a vast amount of arcane power.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 500f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 500f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 500f),
					new Value<Attribute, Float>(Attribute.HEALTH_MAXIMUM, 500f),
					new Value<Attribute, Float>(Attribute.MANA_MAXIMUM, 500f)),
			Util.newArrayListOfValues(
					"[style.boldExcellent(Unlimited)] <b style='color: "+ PresetColour.TRANSFORMATION_GENERIC.toWebHexString()+ ";'> self-transformations</b>",
					"<b style='color: "+ PresetColour.GENERIC_GOOD.toWebHexString()+ ";'>Immune to race transformations</b>"),
			"Lilith's Brood",
			"Lilith's Broods",
			"LILIN_BASIC",
			"LILIN_ADVANCED",
			Race.DEMON,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 1)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 1)),
			PresetColour.RACE_LILIN,
			SubspeciesPreference.ONE_LOW,
			"A lilin.",
			null, Util.newArrayListOfValues(
					SubspeciesFlag.HIDDEN_FROM_PREFERENCES)) {
		@Override
		public void applySpeciesChanges(Body body) {
			body.setSubspeciesOverride(LILIN);
		}
	},
	
	DEMON(true,
			"statusEffects/race/raceDemon",
			"statusEffects/race/raceBackground",
			"demon",
			"demons",
			"incubus",
			"succubus",
			"incubi",
			"succubi",
			"demon",
			"Due to the fact that demons are very easily able to harness arcane power, [npc.namePos] spell-casting abilities are truly a terrifying force to behold!",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 25f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 30f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 100f),
					new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, 25f),
					new Value<Attribute, Float>(Attribute.DAMAGE_LUST, 25f),
					new Value<Attribute, Float>(Attribute.DAMAGE_SPELLS, 75f)),
			Util.newArrayListOfValues(
					"[style.boldDemon(Demonic)] <b style='color: "+ PresetColour.TRANSFORMATION_GENERIC.toWebHexString()+ ";'> self-transformations</b>",
					"<b style='color: "+ PresetColour.GENERIC_GOOD.toWebHexString()+ ";'>Immune to race transformations</b>"),
			"Demonic Origins",
			"Demonic Origins'",
			"DEMON_BASIC",
			"DEMON_ADVANCED",
			Race.DEMON,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 2),
					new Value<>(PerkCategory.LUST, 10),
					new Value<>(PerkCategory.ARCANE, 5)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 10),
					new Value<>(PerkCategory.LUST, 2),
					new Value<>(PerkCategory.ARCANE, 5)),
			PresetColour.RACE_DEMON,
			SubspeciesPreference.FOUR_ABUNDANT,
			"A typical demon.",
			Util.newHashMapOfValues(
					new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.TWO_RARE),
					new Value<>(WorldType.NIGHTLIFE_CLUB,  SubspeciesSpawnRarity.TWO_RARE)), Util.newArrayListOfValues(
					SubspeciesFlag.HIDDEN_FROM_PREFERENCES)) {

		private String[] centaurNames = new String[] {
				"demotaur",
				"demotaurs",
				"incutaur",
				"succutaur",
				"incutaurs",
				"succutaurs"};
		
		@Override
		public void applySpeciesChanges(Body body) {
			if(Math.random()<0.25f && body.getLeg().getType().equals(LegType.DEMON_COMMON)) {
				body.getLeg().setType(null, LegType.DEMON_HOOFED);
			}
			if(Math.random()<0.2f && body.getPenis().getType()!=PenisType.NONE) {
				body.getPenis().getTesticle().setTesticleCount(null, 4);
			}
		}
		
		@Override
		public String getName(GameCharacter character) {
			if(character==null || character.getRaceStage()==RaceStage.GREATER) {
				if(character!=null && character.getLegConfiguration()==LegConfiguration.TAUR) {
					return centaurNames[0];
				}
				return super.getName(character);
			}
			return HALF_DEMON.getName(character);
		}
		
		@Override
		public String getNamePlural(GameCharacter character) {
			if(character==null || character.getRaceStage()==RaceStage.GREATER) {
				if(character!=null && character.getLegConfiguration()==LegConfiguration.TAUR) {
					return centaurNames[1];
				}
				return super.getNamePlural(character);
			}
			return HALF_DEMON.getNamePlural(character);
		}

		@Override
		public String getSingularMaleName(GameCharacter character) {
			if(character==null || character.getRaceStage()==RaceStage.GREATER) {
				if(character!=null && character.getLegConfiguration()==LegConfiguration.TAUR) {
					return centaurNames[2];
				}
				return super.getSingularMaleName(character);
			}
			return HALF_DEMON.getSingularMaleName(character);
		}

		@Override
		public String getSingularFemaleName(GameCharacter character) {
			if(character==null || character.getRaceStage()==RaceStage.GREATER) {
				if(character!=null && character.getLegConfiguration()==LegConfiguration.TAUR) {
					return centaurNames[3];
				}
				return super.getSingularFemaleName(character);
			}
			return HALF_DEMON.getSingularFemaleName(character);
		}

		@Override
		public String getPluralMaleName(GameCharacter character) {
			if(character==null || character.getRaceStage()==RaceStage.GREATER) {
				if(character!=null && character.getLegConfiguration()==LegConfiguration.TAUR) {
					return centaurNames[4];
				}
				return super.getPluralMaleName(character);
			}
			return HALF_DEMON.getPluralMaleName(character);
		}

		@Override
		public String getPluralFemaleName(GameCharacter character) {
			if(character==null || character.getRaceStage()==RaceStage.GREATER) {
				if(character!=null && character.getLegConfiguration()==LegConfiguration.TAUR) {
					return centaurNames[5];
				}
				return super.getPluralFemaleName(character);
			}
			return HALF_DEMON.getPluralFemaleName(character);
		}

		@Override
		public String getSVGString(GameCharacter character) {
			if(character==null || character.getRaceStage()==RaceStage.GREATER) {
				return super.getSVGString(character);
			}
			return HALF_DEMON.getSVGString(character);
		}

		@Override
		public String getSVGStringDesaturated(GameCharacter character) {
			if(character==null || character.getRaceStage()==RaceStage.GREATER) {
				return super.getSVGStringDesaturated(character);
			}
			return HALF_DEMON.getSVGStringDesaturated(character);
		}
	},
	
	HALF_DEMON(false,
			"statusEffects/race/raceDemon",
			"statusEffects/race/raceBackground",
			"half-demon",
			"half-demons",
			"half-incubus",
			"half-succubus",
			"half-incubi",
			"half-succubi",
			"demon",
			"Half-demons are almost as capable as regular demons at harnessing arcane power, and as a result, [npc.namePos] spell-casting abilities are exceptionally powerful!",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 10f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 20f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 50f),
					new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, 20f),
					new Value<Attribute, Float>(Attribute.DAMAGE_LUST, 20f),
					new Value<Attribute, Float>(Attribute.DAMAGE_SPELLS, 60f)),
			Util.newArrayListOfValues(
					"<b style='color: "+ PresetColour.TRANSFORMATION_GENERIC.toWebHexString()+ ";'>Limited self-transformations</b>",
					"<b style='color: "+ PresetColour.GENERIC_GOOD.toWebHexString()+ ";'>Immune to race transformations</b>"),
			"Demonic Half-breeds",
			"Demonic Half-breeds'",
			"HALF_DEMON_BASIC",
			"HALF_DEMON_ADVANCED",
			Race.DEMON,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 3),
					new Value<>(PerkCategory.ARCANE, 2)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 3),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 2)),
			PresetColour.RACE_HALF_DEMON,
			SubspeciesPreference.FOUR_ABUNDANT,
			"The result of copulation between a lilin and a non-demonic partner.",
			Util.newHashMapOfValues(
					new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.ONE_VERY_RARE),
					new Value<>(WorldType.SUBMISSION, SubspeciesSpawnRarity.ONE_VERY_RARE),
					new Value<>(WorldType.HARPY_NEST, SubspeciesSpawnRarity.ONE_VERY_RARE),
					new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.ONE_VERY_RARE)), Util.newArrayListOfValues(
					SubspeciesFlag.HIDDEN_FROM_PREFERENCES)) {
		
		@Override
		public void applySpeciesChanges(Body body) {
		}

		@Override
		public String getFeralName(GameCharacter character) {
			AbstractRace r = character.getLegType().getRace();
			return character.getLegConfiguration()!=LegConfiguration.BIPEDAL
					?r==Race.HUMAN
						?"demonic-horse"
						:"demonic-"+r.getName(character, true)
					:"demon";
		}
		
		@Override
		public String getName(GameCharacter character) {
			if(character==null || character.getHalfDemonSubspecies()==null) {
				return super.getName(character);
			}
			return character.getHalfDemonSubspecies().getHalfDemonName(character)[0];
		}
		
		@Override
		public String getNamePlural(GameCharacter character) {
			if(character==null || character.getHalfDemonSubspecies()==null) {
				return super.getNamePlural(character);
			}
			return character.getHalfDemonSubspecies().getHalfDemonName(character)[1];
		}

		@Override
		public String getSingularMaleName(GameCharacter character) {
			if(character==null || character.getHalfDemonSubspecies()==null) {
				return super.getSingularMaleName(character);
			}
			return character.getHalfDemonSubspecies().getHalfDemonName(character)[2];
		}

		@Override
		public String getSingularFemaleName(GameCharacter character) {
			if(character==null || character.getHalfDemonSubspecies()==null) {
				return super.getSingularFemaleName(character);
			}
			return character.getHalfDemonSubspecies().getHalfDemonName(character)[3];
		}

		@Override
		public String getPluralMaleName(GameCharacter character) {
			if(character==null || character.getHalfDemonSubspecies()==null) {
				return super.getPluralMaleName(character);
			}
			return character.getHalfDemonSubspecies().getHalfDemonName(character)[4];
		}

		@Override
		public String getPluralFemaleName(GameCharacter character) {
			if(character==null || character.getHalfDemonSubspecies()==null) {
				return super.getPluralFemaleName(character);
			}
			return character.getHalfDemonSubspecies().getHalfDemonName(character)[5];
		}

		@Override
		public String getSVGString(GameCharacter character) {
			if(character==null || character.getHalfDemonSubspecies()==null) {
				return Subspecies.HUMAN.getHalfDemonSVGString(character);
			}
			Subspecies coreSubspecies = character.getHalfDemonSubspecies();
			if(coreSubspecies==Subspecies.HALF_DEMON) {
				coreSubspecies = Subspecies.HUMAN;
			}
			return coreSubspecies.getHalfDemonSVGString(character);
		}

		@Override
		public String getSVGStringDesaturated(GameCharacter character) {
			if(character==null || character.getHalfDemonSubspecies()==null) {
				return Subspecies.HUMAN.getSVGStringDesaturated(character);
			}
			Subspecies coreSubspecies = character.getHalfDemonSubspecies();
			if(coreSubspecies==Subspecies.HALF_DEMON) {
				coreSubspecies = Subspecies.HUMAN;
			}
			return coreSubspecies.getSVGStringDesaturated(character);
		}
	},
	
	IMP(false,
			"statusEffects/race/raceImp",
			"statusEffects/race/raceBackground",
			"imp",
			"imps",
			"imp",
			"imp",
			"imps",
			"imps",
			"imp",
			"[npc.NamePos] impish body has a deep, insatiable craving for sex. Due to imps' uncouth mannerisms and reputation as being on the very bottom rung of society, [npc.she] [npc.verb(find)] it difficult to seduce others...",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, -5f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 5f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 200f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_LUST, -25f),
					new Value<Attribute, Float>(Attribute.DAMAGE_LUST, -75f)),
			Util.newArrayListOfValues(
					"[style.boldDemon(Demonic)] <b style='color: "+ PresetColour.TRANSFORMATION_GENERIC.toWebHexString()+ ";'> self-transformations</b>",
					"<b style='color: "+ PresetColour.GENERIC_GOOD.toWebHexString()+ ";'>Immune to race transformations</b>"),
			"Impish Fiends",
			"Impish Fiends'",
			"IMP_BASIC",
			"IMP_ADVANCED",
			Race.DEMON,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 4),
					new Value<>(PerkCategory.LUST, 10),
					new Value<>(PerkCategory.ARCANE, 1)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 8),
					new Value<>(PerkCategory.LUST, 4),
					new Value<>(PerkCategory.ARCANE, 1)),
			PresetColour.RACE_IMP,
			SubspeciesPreference.FOUR_ABUNDANT,
			"A typical imp.",
			Util.newHashMapOfValues(
					new Value<>(WorldType.SUBMISSION, SubspeciesSpawnRarity.FOUR_COMMON)), Util.newArrayListOfValues(
					SubspeciesFlag.HIDDEN_FROM_PREFERENCES)) {
		@Override
		public void applySpeciesChanges(Body body) {
			body.setHeight(Height.NEGATIVE_TWO_MIMIMUM.getRandomValue());
			body.getPenis().setPenisLength(null, 8+Util.random.nextInt(8)); // 3-7 inches
			body.getWing().setSize(null,  WingSize.THREE_LARGE.getValue());
		}
		@Override
		public boolean isShortStature() {
			return true;
		}
		@Override
		public Attribute getDamageMultiplier() {
			return Attribute.DAMAGE_IMP;
		}
	},
	
	IMP_ALPHA(false,
			"statusEffects/race/raceImpAlpha",
			"statusEffects/race/raceBackground",
			"alpha-imp",
			"alpha-imps",
			"alpha-imp",
			"alpha-imp",
			"alpha-imps",
			"alpha-imps",
			"alpha-imp",
			"[npc.NamePos] impish body has a deep, insatiable craving for sex. Due to imps' uncouth mannerisms and reputation as being on the very bottom rung of society, [npc.she] [npc.verb(find)] it difficult to seduce others...",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 5f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 200f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_LUST, -50f),
					new Value<Attribute, Float>(Attribute.DAMAGE_LUST, -50f)),
			Util.newArrayListOfValues(
					"[style.boldDemon(Demonic)] <b style='color: "+ PresetColour.TRANSFORMATION_GENERIC.toWebHexString()+ ";'> self-transformations</b>",
					"<b style='color: "+ PresetColour.GENERIC_GOOD.toWebHexString()+ ";'>Immune to race transformations</b>"),
			"Impish Fiends",
			"Impish Fiends'",
			"IMP_BASIC",
			"IMP_ADVANCED",
			Race.DEMON,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 4),
					new Value<>(PerkCategory.LUST, 10),
					new Value<>(PerkCategory.ARCANE, 1)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 8),
					new Value<>(PerkCategory.LUST, 4),
					new Value<>(PerkCategory.ARCANE, 1)),
			PresetColour.RACE_IMP,
			SubspeciesPreference.ONE_LOW,
			"A more powerful form of imp, standing at over 3'6\" tall.",
			Util.newHashMapOfValues(
					new Value<>(WorldType.SUBMISSION, SubspeciesSpawnRarity.TWO_RARE)), Util.newArrayListOfValues(
					SubspeciesFlag.HIDDEN_FROM_PREFERENCES)) {
		@Override
		public void applySpeciesChanges(Body body) {
			body.setHeight(Height.NEGATIVE_ONE_TINY.getRandomValue());
			body.getPenis().setPenisLength(null, 8+Util.random.nextInt(12)); // 3-8 inches
			body.getWing().setSize(null,  WingSize.THREE_LARGE.getValue());
		}
		@Override
		public boolean isShortStature() {
			return true;
		}
		@Override
		public Attribute getDamageMultiplier() {
			return Attribute.DAMAGE_IMP;
		}
	},
	
	// BOVINES:
	COW_MORPH(true,
			"statusEffects/race/raceCowMorph",
			"statusEffects/race/raceBackground",
			"cow-morph",
			"cow-morphs",
			"cow-boy",
			"cow-girl",
			"cow-boys",
			"cow-girls",
			"cow",
			"Although [npc.namePos] body possesses a great strength and toughness, [npc.her] mind isn't exactly the quickest...",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 30f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, -5f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 10f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_PHYSICAL, 2f)),
			null,
			"Milking Cows",
			"Milking Cows'",
			"COW_MORPH_BASIC",
			"COW_MORPH_ADVANCED",
			Race.COW_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 10),
					new Value<>(PerkCategory.LUST, 10),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 10),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_COW_MORPH,
			SubspeciesPreference.FOUR_ABUNDANT,
			"An anthropomorphic cow, known as a 'cow-morph' when bipedal, and a 'cowtaur' when the lower body is that of a feral cow.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.TWO_RARE),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.TWO_RARE)), null) {
		@Override
		public String[] getHalfDemonName(GameCharacter character) {
			return new String[] {
					"minotaur",
					"minotaurs",
					"minotaur",
					"minotaur",
					"minotaurs",
					"minotaurs"};
		}
	},
	
	// CANIDS:
	DOG_MORPH(true,
			"statusEffects/race/raceDogMorph",
			"statusEffects/race/raceBackground",
			"dog-morph",
			"dog-morphs",
			"dog-boy",
			"dog-girl",
			"dog-boys",
			"dog-girls",
			"dog",
			"[npc.Name] always [npc.has] lots of energy, and [npc.she] [npc.verb(get)] excited about new things very easily."
					+ " [npc.She] also [npc.has] an instinctive desire to display [npc.her] dominance over innocent cat-morphs...",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 10f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.HEALTH_MAXIMUM, 5f),
					new Value<Attribute, Float>(Attribute.DAMAGE_CAT_MORPH, 5f)),
			null,
			"Canine Culture",
			"Canine Cultures",
			"DOG_MORPH_BASIC",
			"DOG_MORPH_ADVANCED",
			Race.DOG_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 3),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_DOG_MORPH,
			SubspeciesPreference.FOUR_ABUNDANT,
			"An anthropomorphic dog, known as a 'dog-morph' when bipedal, and a 'dogtaur' when the lower body is that of an oversized feral dog.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.FOUR_COMMON),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), null) {
				@Override
				public String[] getHalfDemonName(GameCharacter character) {
					String[] names = new String[] {
							"hellhound",
							"hellhounds",
							"hellhound",
							"hellhound",
							"hellhounds",
							"hellhounds"};
					
					if(character!=null && !character.getHalfDemonSubspecies().isNonBiped()) {
						names = new String[] {
							applyNonBipedNameChange(character, "hellhound", false, false),
							applyNonBipedNameChange(character, "hellhound", false, true),
							applyNonBipedNameChange(character, "hellhound", false, false),
							applyNonBipedNameChange(character, "hellhound", true, false),
							applyNonBipedNameChange(character, "hellhound", false, true),
							applyNonBipedNameChange(character, "hellhound", true, true)
						};
					}
					
					return names;
				}
			},
	
	DOG_MORPH_BORDER_COLLIE(false,
			"statusEffects/race/raceDogMorph",
			"statusEffects/race/raceBackground",
			"border-collie-morph",
			"border-collie-morphs",
			"border-collie-boy",
			"border-collie-girl",
			"border-collie-boys",
			"border-collie-girls",
			"border-collie", //TODO sheep-morph damage
			"[npc.NameIsFull] more intelligent than an average dog-morph, and [npc.has] strong urges to try and herd people around."
					+ " [npc.She] also [npc.has] an instinctive desire to display [npc.her] dominance over innocent sheep-morphs...",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 10f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 5f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, 5f),
					new Value<Attribute, Float>(Attribute.HEALTH_MAXIMUM, 5f)),
			null,
			"Canine Culture",
			"Canine Cultures",
			"DOG_MORPH_BASIC",
			"DOG_MORPH_ADVANCED",
			Race.DOG_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 6),
					new Value<>(PerkCategory.LUST, 3),
					new Value<>(PerkCategory.ARCANE, 1)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 6),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 1)),
			PresetColour.RACE_DOG_MORPH,
			SubspeciesPreference.TWO_AVERAGE,
			"A particularly energetic and intelligent dog-morph, which resembles an anthropomorphised border-collie."
				+ " They are known as 'border-collie-morphs' when bipedal, and 'border-collie-taurs' when the lower body is that of an oversized feral border-collie."
				+ " To be identified as a border-collie-morph, a character must be a dog-morph that has either upright or folded ears, and fluffy, black fur with white markings.", Util.newHashMapOfValues(
					new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.FOUR_COMMON),
					new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), null) {
				@Override
				public void applySpeciesChanges(Body body) {
					body.getCoverings().put(BodyCoveringType.CANINE_FUR, new Covering(BodyCoveringType.CANINE_FUR, CoveringPattern.MARKED, CoveringModifier.FLUFFY, PresetColour.COVERING_BLACK, false, PresetColour.COVERING_WHITE, false));
					if(body.getEar().getType()==EarType.DOG_MORPH) {
						if(Math.random()<0.5f) {
							body.getEar().setType(null, EarType.DOG_MORPH_POINTED);
						} else {
							body.getEar().setType(null, EarType.DOG_MORPH_FOLDED);
						}
					}
				}
				@Override
				public String[] getHalfDemonName(GameCharacter character) {
					String[] names = new String[] {
							"hellhound",
							"hellhounds",
							"hellhound",
							"hellhound",
							"hellhounds",
							"hellhounds"};
					
					if(character!=null && !character.getHalfDemonSubspecies().isNonBiped()) {
						names = new String[] {
							applyNonBipedNameChange(character, "hellhound", false, false),
							applyNonBipedNameChange(character, "hellhound", false, true),
							applyNonBipedNameChange(character, "hellhound", false, false),
							applyNonBipedNameChange(character, "hellhound", true, false),
							applyNonBipedNameChange(character, "hellhound", false, true),
							applyNonBipedNameChange(character, "hellhound", true, true)
						};
					}
					
					return names;
				}
			},
	
	DOG_MORPH_DOBERMANN(false,
			"statusEffects/race/raceDogMorphDobermann",
			"statusEffects/race/raceBackground",
			"dobermann",
			"dobermanns",
			"dobermann",
			"dobermann",
			"dobermanns",
			"dobermanns",
			"dobermann",
			"[npc.NameIsFull] always ready to defend those [npc.she] [npc.verb(call)] [npc.her] friend, and, thanks to [npc.her] powerful dobermann's body, [npc.sheIs] able to do just that."
					+ " [npc.She] also [npc.has] an instinctive desire to display [npc.her] dominance over innocent cat-morphs...",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 15f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 15f),
					new Value<Attribute, Float>(Attribute.DAMAGE_CAT_MORPH, 5f)),
			null,
			"Canine Culture",
			"Canine Cultures",
			"DOG_MORPH_BASIC",
			"DOG_MORPH_ADVANCED",
			Race.DOG_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 6),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 10),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_DOG_MORPH,
			SubspeciesPreference.TWO_AVERAGE,
			"A dog-morph which resembles an anthropomorphised dobermann."
					+ " They are known as 'dobermanns' when bipedal, and 'dobermanntaurs' when the lower body is that of an oversized feral dobermann."
					+ " To be identified as a dobermann, a character must be a dog-morph that has short, black fur, with either brown, dark-brown, or tan markings.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.FOUR_COMMON),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), null) {
		@Override
		public void applySpeciesChanges(Body body) {
			Colour secondaryColour = PresetColour.COVERING_BROWN;
			double rand = Math.random();
			if(rand<0.3f) {
				secondaryColour = PresetColour.COVERING_TAN;
			} else if(rand<0.6f) {
				secondaryColour = PresetColour.COVERING_BROWN_DARK;
			}
			body.getCoverings().put(BodyCoveringType.CANINE_FUR, new Covering(BodyCoveringType.CANINE_FUR, CoveringPattern.MARKED, CoveringModifier.SHORT, PresetColour.COVERING_BLACK, false, secondaryColour, false));
			body.getCoverings().put(BodyCoveringType.HAIR_CANINE_FUR, new Covering(BodyCoveringType.HAIR_CANINE_FUR, CoveringPattern.NONE, PresetColour.COVERING_BLACK, false, secondaryColour, false));
			body.getCoverings().put(BodyCoveringType.HUMAN, new Covering(BodyCoveringType.HUMAN, CoveringPattern.NONE, PresetColour.SKIN_EBONY, false, PresetColour.SKIN_EBONY, false));
			body.updateCoverings(true, true, true, true);
			if(body.getPenis().getType()==PenisType.DOG_MORPH) {
				body.getCoverings().put(BodyCoveringType.PENIS, new Covering(BodyCoveringType.PENIS, PresetColour.SKIN_RED));
			}
			if(body.getEar().getType()==EarType.DOG_MORPH) {
				body.getEar().setType(null, EarType.DOG_MORPH_POINTED);
			}
			if(body.getTail().getType()==TailType.DOG_MORPH) {
				body.getTail().setType(null, TailType.DOG_MORPH_STUBBY);
			}
		}
		@Override
		public String[] getHalfDemonName(GameCharacter character) {
			String[] names = new String[] {
					"hellhound",
					"hellhounds",
					"hellhound",
					"hellhound",
					"hellhounds",
					"hellhounds"};
			
			if(character!=null && !character.getHalfDemonSubspecies().isNonBiped()) {
				names = new String[] {
					applyNonBipedNameChange(character, "hellhound", false, false),
					applyNonBipedNameChange(character, "hellhound", false, true),
					applyNonBipedNameChange(character, "hellhound", false, false),
					applyNonBipedNameChange(character, "hellhound", true, false),
					applyNonBipedNameChange(character, "hellhound", false, true),
					applyNonBipedNameChange(character, "hellhound", true, true)
				};
			}
			
			return names;
		}
	},
	
	DOG_MORPH_GERMAN_SHEPHERD(false,
			"statusEffects/race/raceDogMorph",
			"statusEffects/race/raceBackground",
			"german-shepherd-morph",
			"german-shepherd-morphs",
			"german-shepherd-boy",
			"german-shepherd-girl",
			"german-shepherd-boys",
			"german-shepherd-girls",
			"german-shepherd",
			"[npc.NameHasFull] a primitive, wolf-like appearance, and possesses levels of strength and intelligence above that of most other dog-morphs.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 15f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 2f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 5f),
					new Value<Attribute, Float>(Attribute.HEALTH_MAXIMUM, 5f)),
			null,
			"Canine Culture",
			"Canine Cultures",
			"DOG_MORPH_BASIC",
			"DOG_MORPH_ADVANCED",
			Race.DOG_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 6),
					new Value<>(PerkCategory.LUST, 3),
					new Value<>(PerkCategory.ARCANE, 1)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 6),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 1)),
			PresetColour.RACE_DOG_MORPH,
			SubspeciesPreference.TWO_AVERAGE,
			"A strong, intelligent, and loyal subspecies of dog-morph, which resembles an anthropomorphised German-shepherd."
				+ " They are known as 'German-shepherd-morphs' when bipedal, and 'German-shepherd-taurs' when the lower body is that of an oversized feral German-shepherd."
				+ " To be identified as a German-shepherd-morph, a character must be a dog-morph that has upright ears, and fluffy, black fur with tan markings.", Util.newHashMapOfValues(
					new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.FOUR_COMMON),
					new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), null) {
				@Override
				public void applySpeciesChanges(Body body) {
					body.getCoverings().put(BodyCoveringType.CANINE_FUR, new Covering(BodyCoveringType.CANINE_FUR, CoveringPattern.MARKED, CoveringModifier.FLUFFY, PresetColour.COVERING_BLACK, false, PresetColour.COVERING_TAN, false));
					body.getCoverings().put(BodyCoveringType.HAIR_CANINE_FUR, new Covering(BodyCoveringType.HAIR_CANINE_FUR, CoveringPattern.NONE, PresetColour.COVERING_BLACK, false, PresetColour.COVERING_TAN, false));

					if(body.getEar().getType()==EarType.DOG_MORPH) {
						body.getEar().setType(null, EarType.DOG_MORPH_POINTED);
					}
				}
				@Override
				public String[] getHalfDemonName(GameCharacter character) {
					String[] names = new String[] {
							"hellhound",
							"hellhounds",
							"hellhound",
							"hellhound",
							"hellhounds",
							"hellhounds"};
					
					if(character!=null && !character.getHalfDemonSubspecies().isNonBiped()) {
						names = new String[] {
							applyNonBipedNameChange(character, "hellhound", false, false),
							applyNonBipedNameChange(character, "hellhound", false, true),
							applyNonBipedNameChange(character, "hellhound", false, false),
							applyNonBipedNameChange(character, "hellhound", true, false),
							applyNonBipedNameChange(character, "hellhound", false, true),
							applyNonBipedNameChange(character, "hellhound", true, true)
						};
					}
					
					return names;
				}
			},
	
	WOLF_MORPH(true,
			"statusEffects/race/raceWolfMorph",
			"statusEffects/race/raceBackground",
			"wolf-morph",
			"wolf-morphs",
			"wolf-boy",
			"wolf-girl",
			"wolf-boys",
			"wolf-girls",
			"wolf",
			"[npc.NamePos] wolf-like body is very strong, and [npc.she] often [npc.verb(get)] powerful urges to try and dominate people [npc.she] [npc.verb(meet)].",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 20f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 5f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 10f),
					new Value<Attribute, Float>(Attribute.DAMAGE_UNARMED, 25f)),
			null,
			"Prowling Lupines",
			"Prowling Lupines'",
			"WOLF_MORPH_BASIC",
			"WOLF_MORPH_ADVANCED",
			Race.WOLF_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 10),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_WOLF_MORPH,
			SubspeciesPreference.FOUR_ABUNDANT,
			"An anthropomorphic wolf, known as a 'wolf-morph' when bipedal, and a 'wolftaur' when the lower body is that of a typically-oversized feral wolf.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.FOUR_COMMON),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), null) {
		@Override
		public void applySpeciesChanges(Body body) {
			List<Colour> naturalWolfFurColours = Util.newArrayListOfValues(
					PresetColour.COVERING_WHITE,
					PresetColour.COVERING_GREY,
					PresetColour.COVERING_BLACK,
					PresetColour.COVERING_JET_BLACK);
			
			Colour c = Util.randomItemFrom(naturalWolfFurColours);
			body.getCoverings().put(BodyCoveringType.LYCAN_FUR, new Covering(BodyCoveringType.LYCAN_FUR, c));
			body.getCoverings().put(BodyCoveringType.HAIR_LYCAN_FUR, new Covering(BodyCoveringType.HAIR_LYCAN_FUR, c));
			body.getCoverings().put(BodyCoveringType.BODY_HAIR_LYCAN_FUR, new Covering(BodyCoveringType.BODY_HAIR_LYCAN_FUR, c));
		}
		public String[] getHalfDemonName(GameCharacter character) {
			String[] names = new String[] {
					"vargr",
					"vargar",
					"vargr",
					"vargr",
					"vargar",
					"vargar"};
			
			if(character!=null && !character.getHalfDemonSubspecies().isNonBiped()) {
				names = new String[] {
					applyNonBipedNameChange(character, "vargr", false, false),
					applyNonBipedNameChange(character, "vargr", false, true),
					applyNonBipedNameChange(character, "vargr", false, false),
					applyNonBipedNameChange(character, "vargr", true, false),
					applyNonBipedNameChange(character, "vargr", false, true),
					applyNonBipedNameChange(character, "vargr", true, true)
				};
			}
			
			return names;
		}
	},
	
	FOX_MORPH(true,
			"statusEffects/race/raceFoxMorph",
			"statusEffects/race/raceBackground",
			"fox-morph",
			"fox-morphs",
			"fox-boy",
			"fox-girl",
			"fox-boys",
			"fox-girls",
			"fox",
			"[npc.NameIsFull] very sly and nimble, and [npc.sheIs] able to use [npc.her] heightened senses to detect opportune moments in which to attack.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 5f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 5f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.ENERGY_SHIELDING, 1f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 10f)),
			null,
			"Skulking Vulpines",
			"Skulking Vulpines",
			"FOX_MORPH_BASIC",
			"FOX_MORPH_ADVANCED",
			Race.FOX_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 6),
					new Value<>(PerkCategory.LUST, 3),
					new Value<>(PerkCategory.ARCANE, 1)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 6),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 1)),
			PresetColour.RACE_FOX_MORPH,
			SubspeciesPreference.FOUR_ABUNDANT,
			"An anthropomorphic fox, known as a 'fox-morph' when bipedal, and a 'foxtaur' when the lower body is that of a typically-oversized feral fox.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.FOUR_COMMON),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), null) {
		@Override
		public void applySpeciesChanges(Body body) {
			Subspecies.applyFoxColoring(body);
		}
	},

	FOX_MORPH_ARCTIC(false,
			"statusEffects/race/raceFoxMorph",
			"statusEffects/race/raceBackground",
			"arctic-fox-morph",
			"arctic-fox-morphs",
			"arctic-fox-boy",
			"arctic-fox-girl",
			"arctic-fox-boys",
			"arctic-fox-girls",
			"arctic-fox",
			"[npc.NameIsFull] very sly and nimble, and [npc.sheIs] able to use [npc.her] heightened senses to detect opportune moments in which to attack."
					+ " As [npc.sheIsFull] adapted to arctic conditions, [npc.sheIs] also better able to resist incoming cold damage.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 5f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 5f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.ENERGY_SHIELDING, 1f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 10f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_ICE, 5f)),
			null,
			"Skulking Vulpines",
			"Skulking Vulpines",
			"FOX_MORPH_BASIC",
			"FOX_MORPH_ADVANCED",
			Race.FOX_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 10),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 1)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 10),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 1)),
			PresetColour.RACE_FOX_MORPH_ARCTIC,
			SubspeciesPreference.ONE_LOW,
			"An anthropomorphic fox with white fur, known as an 'arctic-fox-morph' when bipedal, and an 'arctic-foxtaur' when the lower body is that of a typically-oversized feral fox.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.TWO_RARE),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.TWO_RARE)), null) {
		@Override
		public void applySpeciesChanges(Body body) {
			body.getCoverings().put(BodyCoveringType.HUMAN, new Covering(BodyCoveringType.HUMAN, CoveringPattern.NONE, PresetColour.SKIN_PALE, false, PresetColour.SKIN_PALE, true));
			body.getCoverings().put(BodyCoveringType.FOX_FUR, new Covering(BodyCoveringType.FOX_FUR, CoveringPattern.NONE, PresetColour.COVERING_WHITE, false, PresetColour.COVERING_WHITE, false));
			body.getCoverings().put(BodyCoveringType.HAIR_FOX_FUR, new Covering(BodyCoveringType.HAIR_FOX_FUR, CoveringPattern.NONE, PresetColour.COVERING_WHITE, false, PresetColour.COVERING_WHITE, false));
			body.getCoverings().put(BodyCoveringType.BODY_HAIR_FOX_FUR, new Covering(BodyCoveringType.BODY_HAIR_FOX_FUR, CoveringPattern.NONE, PresetColour.COVERING_WHITE, false, PresetColour.COVERING_WHITE, false));
		}
	},
	
	FOX_MORPH_FENNEC(false,
			"statusEffects/race/raceFoxMorph",
			"statusEffects/race/raceBackground",
			"fennec-morph",
			"fennec-morphs",
			"fennec-boy",
			"fennec-girl",
			"fennec-boys",
			"fennec-girls",
			"fennec-fox",
			"[npc.NameIsFull] very sly and nimble, and [npc.sheIs] able to use [npc.her] heightened senses to detect opportune moments in which to attack.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 5f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 5f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.ENERGY_SHIELDING, 1f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 10f)),
			null,
			"Skulking Vulpines",
			"Skulking Vulpines",
			"FOX_MORPH_BASIC",
			"FOX_MORPH_ADVANCED",
			Race.FOX_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 10),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 1)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 10),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 1)),
			PresetColour.RACE_FOX_MORPH,
			SubspeciesPreference.FOUR_ABUNDANT,
			"An anthropomorphic fox with distinctive large ears, and with either tan, dirty blonde, or bleach-blonde fur."
			+ " They are known as a 'fennec-morph' when bipedal, and a 'fennectaur' when the lower body is that of a typically-oversized feral fennec fox.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.FOUR_COMMON),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), null) {
		@Override
		public void applySpeciesChanges(Body body) {
			Colour fennecColour = Util.randomItemFrom(Util.newArrayListOfValues(PresetColour.COVERING_DIRTY_BLONDE, PresetColour.COVERING_BLEACH_BLONDE, PresetColour.COVERING_TAN));
			
			body.getCoverings().put(BodyCoveringType.FOX_FUR, new Covering(BodyCoveringType.FOX_FUR, CoveringPattern.NONE, fennecColour, false, fennecColour, false));
			body.getCoverings().put(BodyCoveringType.HAIR_FOX_FUR, new Covering(BodyCoveringType.FOX_FUR, CoveringPattern.NONE, fennecColour, false, fennecColour, false));
			body.getCoverings().put(BodyCoveringType.HUMAN, new Covering(BodyCoveringType.HUMAN, CoveringPattern.NONE, PresetColour.SKIN_OLIVE, false, PresetColour.SKIN_OLIVE, false));
			body.updateCoverings(true, true, true, true);
			if(body.getPenis().getType()==PenisType.FOX_MORPH) {
				body.getCoverings().put(BodyCoveringType.PENIS, new Covering(BodyCoveringType.PENIS, PresetColour.SKIN_RED));
			}
			if(body.getEar().getType()==EarType.FOX_MORPH) {
				body.getEar().setType(null, EarType.FOX_MORPH_BIG);
			}
		}
	},
	
	FOX_ASCENDANT(false,
			"statusEffects/race/raceFoxMorph",
			"statusEffects/race/raceBackground",
			"youko",
			"youko",
			"youko-boy",
			"youko-girl",
			"youko-boys",
			"youko-girls",
			"youko",
			"",
			null,
			null,
			"Nine-tails",
			"Nine-tails'",
			"FOX_MORPH_BASIC",
			"FOX_MORPH_ADVANCED",
			Race.FOX_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 10)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 5)),
			PresetColour.RACE_FOX_MORPH,
			SubspeciesPreference.FOUR_ABUNDANT,
			"A fox-morph, empowered by the gifts of a Lilin.",
			Util.newHashMapOfValues(), Util.newArrayListOfValues(
					SubspeciesFlag.DISBALE_SPAWN_PREFERENCE)) {
		@Override
		public boolean isAbleToSelfTransform() {
			return true;
		}
		@Override
		public void applySpeciesChanges(Body body) {
			Subspecies.applyFoxColoring(body);
			if(body.getTail().getType()==TailType.FOX_MORPH) {
				body.getTail().setType(null, TailType.FOX_MORPH_MAGIC);
			}
		}
		
		@Override
		public String getStatusEffectDescription(GameCharacter character) {
			if(character.getTailCount()<9) {
				return UtilText.parse(character, "[npc.NameIsFull] a fox-morph, [npc.his] service to a particular Lilin having afforded [npc.him] [npc.tailCount] arcane tail"+(character.getTailCount()==1?"":"s")+".");
			} else {
				return UtilText.parse(character, "[npc.NameIsFull] a fox-morph, [npc.his] vast number of arcane tails a sign of [npc.her] unending devotion to a particular Lilin.");
			}
		}

		@Override
		public Map<Attribute, Float> getStatusEffectAttributeModifiers(GameCharacter character) {
			if(character!=null && character.getTailCount()<9) {
				return Util.newHashMapOfValues(
						new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 5f),
						new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, (float) (10*character.getTailCount())),
						new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
						new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, (float) (10 + 5*character.getTailCount())),
						new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, (float) (20 + 5*character.getTailCount())));
			} else {
				return Util.newHashMapOfValues(
						new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 5f),
						new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 100f),
						new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
						new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, 25f),
						new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 100f));
			}
		}

		@Override
		public String getSVGString(GameCharacter character) {
			if(character==null) {
				return youkoIconMap.get(9);
			}
			return getBipedBackground(youkoIconMap.get(character.getTailCount()), character, this.getColour(character));
		}

		@Override
		public String getSVGStringDesaturated(GameCharacter character) {
			if(character==null) {
				return youkoDesaturatedIconMap.get(9);
			}
			return getBipedBackground(youkoDesaturatedIconMap.get(character.getTailCount()), character, PresetColour.BASE_GREY);
		}
		
		@Override
		public String getHalfDemonSVGString(GameCharacter character) {
			if(character!=null && character.getSubspeciesOverride()!=null && character.getSubspeciesOverride().equals(Subspecies.DEMON)) {
				return super.getHalfDemonSVGString(character);
			} else {
				return getBipedBackground(youkoHalfDemonIconMap.get(character.getTailCount()), character, PresetColour.RACE_HALF_DEMON);
			}
		}
	},

	FOX_ASCENDANT_ARCTIC(false,
			"statusEffects/race/raceFoxMorph",
			"statusEffects/race/raceBackground",
			"arctic-youko",
			"arctic-youko",
			"arctic-youko-boy",
			"arctic-youko-girl",
			"arctic-youko-boys",
			"arctic-youko-girls",
			"arctic-youko",
			"",
			null,
			null,
			"Nine-tails",
			"Nine-tails'", "FOX_MORPH_BASIC",
			"FOX_MORPH_ADVANCED",
			Race.FOX_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 10)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 5)),
			PresetColour.RACE_FOX_MORPH,
			SubspeciesPreference.FOUR_ABUNDANT,
			"An arctic-fox-morph, empowered by the gifts of a Lilin.",
			Util.newHashMapOfValues(), Util.newArrayListOfValues()) {
		@Override
		public boolean isAbleToSelfTransform() {
			return true;
		}
		@Override
		public void applySpeciesChanges(Body body) {
			body.getCoverings().put(BodyCoveringType.HUMAN, new Covering(BodyCoveringType.HUMAN, CoveringPattern.NONE, PresetColour.SKIN_PALE, false, PresetColour.SKIN_PALE, true));
			body.getCoverings().put(BodyCoveringType.FOX_FUR, new Covering(BodyCoveringType.FOX_FUR, CoveringPattern.NONE, PresetColour.COVERING_WHITE, false, PresetColour.COVERING_WHITE, false));
			body.getCoverings().put(BodyCoveringType.HAIR_FOX_FUR, new Covering(BodyCoveringType.HAIR_FOX_FUR, CoveringPattern.NONE, PresetColour.COVERING_WHITE, false, PresetColour.COVERING_WHITE, false));
			body.getCoverings().put(BodyCoveringType.BODY_HAIR_FOX_FUR, new Covering(BodyCoveringType.BODY_HAIR_FOX_FUR, CoveringPattern.NONE, PresetColour.COVERING_WHITE, false, PresetColour.COVERING_WHITE, false));
			if(body.getTail().getType()==TailType.FOX_MORPH) {
				body.getTail().setType(null, TailType.FOX_MORPH_MAGIC);
			}
		}
		
		@Override
		public String getStatusEffectDescription(GameCharacter character) {
			if(character.getTailCount()<9) {
				return UtilText.parse(character, "[npc.NameIsFull] an arctic-fox-morph, [npc.his] service to a particular Lilin having afforded [npc.him] [npc.tailCount] arcane tail"+(character.getTailCount()==1?"":"s")+".");
			} else {
				return UtilText.parse(character, "[npc.NameIsFull] an arctic-fox-morph, [npc.his] vast number of arcane tails a sign of [npc.her] unending devotion to a particular Lilin.");
			}
		}

		@Override
		public Map<Attribute, Float> getStatusEffectAttributeModifiers(GameCharacter character) {
			if(character!=null && character.getTailCount()<9) {
				return Util.newHashMapOfValues(
						new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 5f),
						new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, (float) (10*character.getTailCount())),
						new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
						new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, (float) (10 + 5*character.getTailCount())),
						new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, (float) (20 + 5*character.getTailCount())));
			} else {
				return Util.newHashMapOfValues(
						new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 5f),
						new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 100f),
						new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
						new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, 25f),
						new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 100f));
			}
		}
		
		@Override
		public String getSVGString(GameCharacter character) {
			return FOX_ASCENDANT.getSVGString(character);
		}

		@Override
		public String getSVGStringDesaturated(GameCharacter character) {
			return FOX_ASCENDANT.getSVGStringDesaturated(character);
		}
	},
	
	FOX_ASCENDANT_FENNEC(false,
			"statusEffects/race/raceFoxMorph",
			"statusEffects/race/raceBackground",
			"fennec-youko",
			"fennec-youko",
			"fennec-youko-boy",
			"fennec-youko-girl",
			"fennec-youko-boys",
			"fennec-youko-girls",
			"fennec-youko",
			"",
			null,
			null,
			"Nine-tails",
			"Nine-tails'", "FOX_MORPH_BASIC",
			"FOX_MORPH_ADVANCED",
			Race.FOX_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 10)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 5)),
			PresetColour.RACE_FOX_MORPH,
			SubspeciesPreference.FOUR_ABUNDANT,
			"A fennec-morph, empowered by the gifts of a Lilin.",
			Util.newHashMapOfValues(), Util.newArrayListOfValues()) {
		@Override
		public boolean isAbleToSelfTransform() {
			return true;
		}
		@Override
		public void applySpeciesChanges(Body body) {
			Colour fennecColour = PresetColour.COVERING_BLEACH_BLONDE;
			double rand = Math.random();
			if(rand<0.5f) {
				fennecColour = PresetColour.COVERING_DIRTY_BLONDE;
			}
			body.getCoverings().put(BodyCoveringType.FOX_FUR, new Covering(BodyCoveringType.FOX_FUR, CoveringPattern.NONE, fennecColour, false, fennecColour, false));
			body.getCoverings().put(BodyCoveringType.HAIR_FOX_FUR, new Covering(BodyCoveringType.FOX_FUR, CoveringPattern.NONE, fennecColour, false, fennecColour, false));
			body.getCoverings().put(BodyCoveringType.HUMAN, new Covering(BodyCoveringType.HUMAN, CoveringPattern.NONE, PresetColour.SKIN_OLIVE, false, PresetColour.SKIN_OLIVE, false));
			body.updateCoverings(true, true, true, true);
			if(body.getPenis().getType()==PenisType.FOX_MORPH) {
				body.getCoverings().put(BodyCoveringType.PENIS, new Covering(BodyCoveringType.PENIS, PresetColour.SKIN_RED));
			}
			if(body.getEar().getType()==EarType.FOX_MORPH) {
				body.getEar().setType(null, EarType.FOX_MORPH_BIG);
			}
			if(body.getTail().getType()==TailType.FOX_MORPH) {
				body.getTail().setType(null, TailType.FOX_MORPH_MAGIC);
			}
		}
		@Override
		public String getStatusEffectDescription(GameCharacter character) {
			if(character.getTailCount()<9) {
				return UtilText.parse(character, "[npc.NameIsFull] a fox-morph, [npc.his] service to a particular Lilin having afforded [npc.him] [npc.tailCount] arcane tail"+(character.getTailCount()==1?"":"s")+".");
			} else {
				return UtilText.parse(character, "[npc.NameIsFull] a fox-morph, [npc.his] vast number of arcane tails a sign of [npc.her] unending devotion to a particular Lilin.");
			}
		}
		@Override
		public Map<Attribute, Float> getStatusEffectAttributeModifiers(GameCharacter character) {
			if(character!=null && character.getTailCount()<9) {
				return Util.newHashMapOfValues(
						new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 5f),
						new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, (float) (10*character.getTailCount())),
						new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
						new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, (float) (10 + 5*character.getTailCount())),
						new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, (float) (20 + 5*character.getTailCount())));
			} else {
				return Util.newHashMapOfValues(
						new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 5f),
						new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 100f),
						new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
						new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, 25f),
						new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 100f));
			}
		}
		@Override
		public String getSVGString(GameCharacter character) {
			return FOX_ASCENDANT.getSVGString(character);
		}
		@Override
		public String getSVGStringDesaturated(GameCharacter character) {
			return FOX_ASCENDANT.getSVGStringDesaturated(character);
		}
	},
	
//	FOX_TAILED("statusEffects/race/raceFoxMorph",
//			"pipefox",
//			"pipefoxes",
//			"pipefox-boy",
//			"pipefox-girl",
//			"pipefox-boys",
//			"pipefox-girls",
//			Race.FOX_MORPH,
//			PresetColour.RACE_FOX_MORPH,
//			SubspeciesPreference.FOUR_ABUNDANT,
//			"A fox-morph with a serpentine lower body, devoid of legs.",
//			Util.newHashMapOfValues(WorldType.DOMINION)) {
//		@Override
//		public void applySpeciesChanges(Body body) {
//			//apply fox coloring
//		}
//	},
	
//	FOX_TAUR("statusEffects/race/raceFoxMorph",
//			"yegan",
//			"yegans",
//			"yegan-boy",
//			"yegan-girl",
//			"yegan-boys",
//			"yegan-girls",
//			Race.FOX_MORPH,
//			PresetColour.RACE_FOX_MORPH,
//			SubspeciesPreference.FOUR_ABUNDANT,
//			"A fox-morph a bestial lower body that walks on four legs.",
//			Util.newHashMapOfValues(WorldType.DOMINION)) {
//		@Override
//		public void applySpeciesChanges(Body body) {
//			//apply fox coloring
//		}
//	},

	// FELINES:
	CAT_MORPH(true,
			"statusEffects/race/raceCatMorph",
			"statusEffects/race/raceBackground",
			"cat-morph",
			"cat-morphs",
			"cat-boy",
			"cat-girl",
			"cat-boys",
			"cat-girls",
			"cat",
			"[npc.NamePos] body is incredibly agile, and [npc.she] [npc.verb(possess)] lightning reflexes."
					+ " [npc.She] also [npc.has] an instinctive desire to display [npc.her] dominance over innocent harpies and rodent-morphs...",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 5f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 10f),
					new Value<Attribute, Float>(Attribute.DAMAGE_HARPY, 5f),
					new Value<Attribute, Float>(Attribute.DAMAGE_RAT_MORPH, 5f),
					new Value<Attribute, Float>(Attribute.DAMAGE_SQUIRREL_MORPH, 5f)),
			null,
			"Curious Kitties",
			"Curious Kitties",
			"CAT_MORPH_BASIC",
			"CAT_MORPH_ADVANCED",
			Race.CAT_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 2),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 2),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_CAT_MORPH,
			SubspeciesPreference.FOUR_ABUNDANT,
			"An anthropomorphic cat, known as a 'cat-morph' when bipedal, and a 'cattaur' when the lower body is that of a typically-oversized feral cat.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.FOUR_COMMON),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), null) {
		@Override
		public void applySpeciesChanges(Body body) {
		}
	},
	
	CAT_MORPH_LYNX(false,
			"statusEffects/race/raceCatMorph",
			"statusEffects/race/raceBackground",
			"lynx-morph",
			"lynx-morphs",
			"lynx",
			"lynx",
			"lynxes",
			"lynxes",
			"lynx",//TODO sheep
			"[npc.NamePos] body is incredibly agile, and [npc.she] [npc.verb(possess)] lightning reflexes."
					+ " [npc.She] also [npc.has] an instinctive desire to display [npc.her] dominance over innocent harpies and rodent-morphs...",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 10f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 10f),
					new Value<Attribute, Float>(Attribute.DAMAGE_HARPY, 5f),
					new Value<Attribute, Float>(Attribute.DAMAGE_HARPY, 5f),
					new Value<Attribute, Float>(Attribute.DAMAGE_RAT_MORPH, 5f),
					new Value<Attribute, Float>(Attribute.DAMAGE_SQUIRREL_MORPH, 5f)),
			null,
			"Curious Kitties",
			"Curious Kitties",
			"CAT_MORPH_BASIC",
			"CAT_MORPH_ADVANCED",
			Race.CAT_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 10),
					new Value<>(PerkCategory.LUST, 2),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_CAT_MORPH_LYNX,
			SubspeciesPreference.TWO_AVERAGE,
			"An anthropomorphic lynx, known as a 'lynx-morph' when bipedal, and a 'lynxtaur' when the lower body is that of a typically-oversized feral lynx."
					+ " To be identified as a Lynx-morph, a character must be a cat-morph that has fluffy fur, tufted ears, a short tail, and side-fluff hair type.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.FOUR_COMMON),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), null) {
		@Override
		public void applySpeciesChanges(Body body) {
			Colour primaryColor = PresetColour.COVERING_BROWN;
			double rand = Math.random();
			if(rand<0.3f) {
				primaryColor = PresetColour.COVERING_TAN;
			} else if(rand<0.6f) {
				primaryColor = PresetColour.COVERING_BROWN_DARK;
			}
			body.getCoverings().put(BodyCoveringType.FELINE_FUR, new Covering(BodyCoveringType.FELINE_FUR, CoveringPattern.SPOTTED, CoveringModifier.FLUFFY, primaryColor, false, PresetColour.COVERING_BLACK, false));
			body.getCoverings().put(BodyCoveringType.HAIR_FELINE_FUR, new Covering(BodyCoveringType.FELINE_FUR, CoveringPattern.NONE, primaryColor, false, PresetColour.COVERING_BLACK, false));
			body.updateCoverings(true, true, true, true);
			if(body.getEar().getType().getRace()==Race.CAT_MORPH) {
				body.getEar().setType(null, EarType.CAT_MORPH_TUFTED);
			}
			if(body.getTail().getType().getRace()==Race.CAT_MORPH) {
				body.getTail().setType(null, TailType.CAT_MORPH_SHORT);
			}
			if(body.getHair().getType().getRace()==Race.CAT_MORPH) {
				body.getHair().setType(null, HairType.CAT_MORPH_SIDEFLUFF);
			}
		}
	},
	
	CAT_MORPH_LEOPARD_SNOW(false,
			"statusEffects/race/raceCatMorph",
			"statusEffects/race/raceBackgroundSnowLeopard",
			"snow leopard-morph",
			"snow leopard-morphs",
			"snow leopard",
			"snow leopardess",
			"snow leopards",
			"snow leopardesses",
			"snow leopard",
			"[npc.NamePos] body is very strong and agile, and [npc.sheIsFull] capable of great feats of strength and stealth alike."
					+ " [npc.She] also [npc.has] a very high resistance to both natural and arcane cold.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 20f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 15f),
					new Value<Attribute, Float>(Attribute.DAMAGE_UNARMED, 5f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 5f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_ICE, 5f)),
			null,
			"Curious Kitties",
			"Curious Kitties",
			"CAT_MORPH_BASIC",
			"CAT_MORPH_ADVANCED",
			Race.CAT_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 10),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 10),
					new Value<>(PerkCategory.LUST, 2),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_CAT_MORPH_LEOPARD_SNOW,
			SubspeciesPreference.TWO_AVERAGE,
			"An anthropomorphic snow leopard, known as a 'snow leopard-morph' when bipedal, and a 'snow leopardtaur' when the lower body is that of a typically-oversized feral snow leopard."
					+ " To be identified as a snow leopard-morph, a character must be a cat-morph that has fluffy spotted fur, normal tail and panther face.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.FOUR_COMMON),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), null) {
		@Override
		public void applySpeciesChanges(Body body) {
			Colour primaryColor = PresetColour.COVERING_WHITE;
			Colour secondaryColor = PresetColour.COVERING_BLACK;
			double rand = Math.random();
			if(rand<0.3f) {
				primaryColor = PresetColour.COVERING_WHITE;
			} else if(rand<0.6f) {
				primaryColor = PresetColour.COVERING_GREY;
			} else if(rand<0.65f) {
				primaryColor = PresetColour.COVERING_BLACK;
			}
			body.getCoverings().put(BodyCoveringType.FELINE_FUR, new Covering(BodyCoveringType.FELINE_FUR, CoveringPattern.SPOTTED, CoveringModifier.FLUFFY, primaryColor, false, secondaryColor, false));
			body.getCoverings().put(BodyCoveringType.HAIR_FELINE_FUR, new Covering(BodyCoveringType.FELINE_FUR, CoveringPattern.NONE, primaryColor, false, secondaryColor, false));
			body.updateCoverings(true, true, true, true);
			if(body.getFace().getType()==FaceType.CAT_MORPH) {
				body.getFace().setType(null, FaceType.CAT_MORPH_PANTHER);
			}
			if(body.getTail().getType().getRace()==Race.CAT_MORPH) {
				body.getTail().setType(null, TailType.CAT_MORPH);
				body.getTail().setTailGirth(null, PenetrationGirth.FOUR_THICK.getValue());
			}
			
			body.setBodySize(BodySize.TWO_AVERAGE.getMedianValue());
			body.setMuscle(Muscle.FOUR_RIPPED.getMedianValue());
		}
	},
	
	CAT_MORPH_LEOPARD(false,
			"statusEffects/race/raceCatMorph",
			"statusEffects/race/raceBackgroundLeopard",
			"leopard-morph",
			"leopard-morphs",
			"leopard",
			"leopardess",
			"leopard",
			"leopardesses",
			"leopard",
			"[npc.NamePos] body is very strong and agile, and [npc.sheIsFull] capable of great feats of strength and stealth alike."
					+ " [npc.She] also [npc.has] a high resistance to both natural and arcane heat.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 20f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 15f),
					new Value<Attribute, Float>(Attribute.DAMAGE_UNARMED, 5f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 5f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_FIRE, 5f)),
			null,
			"Curious Kitties",
			"Curious Kitties",
			"CAT_MORPH_BASIC",
			"CAT_MORPH_ADVANCED",
			Race.CAT_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 10),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 10),
					new Value<>(PerkCategory.LUST, 2),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_CAT_MORPH_LEOPARD,
			SubspeciesPreference.TWO_AVERAGE,
			"An anthropomorphic leopard, known as a 'leopard-morph' when bipedal, and a 'leopardtaur' when the lower body is that of a typically-oversized feral leopard."
					+ " To be identified as a leopard-morph, a character must be a cat-morph that has short spotted fur, normal tail and panther face.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.FOUR_COMMON),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), null) {
		@Override
		public void applySpeciesChanges(Body body) {
			Colour primaryColor = PresetColour.COVERING_ORANGE;
			Colour secondaryColor = PresetColour.COVERING_BLACK;
			double rand = Math.random();
			if(rand<0.05f) {
				primaryColor = PresetColour.COVERING_BLACK;
			}
			body.getCoverings().put(BodyCoveringType.FELINE_FUR, new Covering(BodyCoveringType.FELINE_FUR, CoveringPattern.SPOTTED, CoveringModifier.SHORT, primaryColor, false, secondaryColor, false));
			body.getCoverings().put(BodyCoveringType.HAIR_FELINE_FUR, new Covering(BodyCoveringType.FELINE_FUR, CoveringPattern.NONE, primaryColor, false, secondaryColor, false));
			body.updateCoverings(true, true, true, true);
			if(body.getFace().getType()==FaceType.CAT_MORPH) {
				body.getFace().setType(null, FaceType.CAT_MORPH_PANTHER);
			}
			if(body.getTail().getType().getRace()==Race.CAT_MORPH) {
				body.getTail().setType(null, TailType.CAT_MORPH);
			}
			body.setBodySize(BodySize.TWO_AVERAGE.getMedianValue());
			body.setMuscle(Muscle.FOUR_RIPPED.getMedianValue());
		}
	},
	
	CAT_MORPH_LION(false,
			"statusEffects/race/raceCatMorph",
			"statusEffects/race/raceBackground",
			"lion-morph",
			"lion-morphs",
			"lion",
			"lioness",
			"lions",
			"lionesses",
			"lion",
			"[npc.NamePos] body is extremely strong, and [npc.sheIsFull] capable of great feats of strength."
					+ " [npc.She] also [npc.has] a high resistance to both natural and arcane heat.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 30f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.DAMAGE_UNARMED, 15f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 15f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_FIRE, 5f)),
			null,
			"Curious Kitties",
			"Curious Kitties",
			"CAT_MORPH_BASIC",
			"CAT_MORPH_ADVANCED",
			Race.CAT_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 20),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 20),
					new Value<>(PerkCategory.LUST, 2),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_CAT_MORPH_LION,
			SubspeciesPreference.TWO_AVERAGE,
			"An anthropomorphic lion, known as a 'lion-morph' when bipedal, and a 'liontaur' when the lower body is that of a feral lion."
					+ " To be identified as a lion-morph, a character must be a cat-morph that has short fur, tufted tail and panther face.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.FOUR_COMMON),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), null) {
		@Override
		public void applySpeciesChanges(Body body) {
			Colour primaryColor = PresetColour.COVERING_TAN;
			Colour secondaryColor = PresetColour.COVERING_BLACK;
			double rand = Math.random();
			if(rand<0.05f) {
				primaryColor = PresetColour.COVERING_BLACK;
			}
			else if(rand<0.1f) {
				primaryColor = PresetColour.COVERING_WHITE;
			}
			body.getCoverings().put(BodyCoveringType.FELINE_FUR, new Covering(BodyCoveringType.FELINE_FUR, CoveringPattern.NONE, CoveringModifier.SHORT, primaryColor, false, secondaryColor, false));
			body.getCoverings().put(BodyCoveringType.HAIR_FELINE_FUR, new Covering(BodyCoveringType.FELINE_FUR, CoveringPattern.NONE, primaryColor, false, secondaryColor, false));
			body.updateCoverings(true, true, true, true);
			if(body.getFace().getType()==FaceType.CAT_MORPH) {
				body.getFace().setType(null, FaceType.CAT_MORPH_PANTHER);
			}
			if(body.getTail().getType().getRace()==Race.CAT_MORPH) {
				body.getTail().setType(null, TailType.CAT_MORPH_TUFTED);
			}
			body.setBodySize(BodySize.TWO_AVERAGE.getMedianValue());
			body.setMuscle(Muscle.FOUR_RIPPED.getMedianValue());
		}
	},
	
	CAT_MORPH_TIGER(false,
			"statusEffects/race/raceCatMorph",
			"statusEffects/race/raceBackgroundTiger",
			"tiger-morph",
			"tiger-morphs",
			"tiger",
			"tigress",
			"tigers",
			"tigresses",
			"tiger",
			"[npc.NamePos] body is extremely strong, and [npc.sheIsFull] capable of great feats of strength.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 30f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.DAMAGE_UNARMED, 25f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 25f)),
			null,
			"Curious Kitties",
			"Curious Kitties",
			"CAT_MORPH_BASIC",
			"CAT_MORPH_ADVANCED",
			Race.CAT_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 20),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 20),
					new Value<>(PerkCategory.LUST, 2),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_CAT_MORPH_TIGER,
			SubspeciesPreference.TWO_AVERAGE,
			"An anthropomorphic tiger, known as a 'tiger-morph' when bipedal, and a 'tigertaur' when the lower body is that of a feral tiger."
					+ " To be identified as a tiger-morph, a character must be a cat-morph that has striped fur, normal tail and panther face.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.FOUR_COMMON),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), null) {
		@Override
		public void applySpeciesChanges(Body body) {
			Colour primaryColor = PresetColour.COVERING_ORANGE;
			Colour secondaryColor = PresetColour.COVERING_BLACK;
			double rand = Math.random();
			if(rand<0.6f) {
				primaryColor = Util.randomItemFrom(Util.newArrayListOfValues(PresetColour.COVERING_TAN, PresetColour.COVERING_AUBURN, PresetColour.COVERING_AMBER));
			} else if(rand<0.12f) {
				primaryColor = PresetColour.COVERING_WHITE;
			} else if(rand<0.16f) {
				primaryColor = PresetColour.COVERING_BLACK;
			}
			body.getCoverings().put(BodyCoveringType.FELINE_FUR, new Covering(BodyCoveringType.FELINE_FUR, CoveringPattern.STRIPED, CoveringModifier.SHORT, primaryColor, false, secondaryColor, false));
			body.getCoverings().put(BodyCoveringType.HAIR_FELINE_FUR, new Covering(BodyCoveringType.FELINE_FUR, CoveringPattern.NONE, primaryColor, false, secondaryColor, false));
			body.updateCoverings(true, true, true, true);
			if(body.getFace().getType()==FaceType.CAT_MORPH) {
				body.getFace().setType(null, FaceType.CAT_MORPH_PANTHER);
			}
			if(body.getTail().getType().getRace()==Race.CAT_MORPH) {
				body.getTail().setType(null, TailType.CAT_MORPH);
			}
			body.setBodySize(BodySize.TWO_AVERAGE.getMedianValue());
			body.setMuscle(Muscle.FOUR_RIPPED.getMedianValue());
		}
	},
	
	CAT_MORPH_CHEETAH(false,
			"statusEffects/race/raceCatMorph",
			"statusEffects/race/raceBackgroundCheetah",
			"cheetah-morph",
			"cheetah-morphs",
			"cheetah",
			"cheetah",
			"cheetahs",
			"cheetahs",
			"cheetah",
			"[npc.NameIsFull] extremely fast, and in short bursts, is capable of running at speeds far greater than any other race.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 5f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 25f)),
			Util.newArrayListOfValues("[style.boldExcellent(100%)] chance of escape vs non-cheetah-morphs"),
			"Curious Kitties",
			"Curious Kitties",
			"CAT_MORPH_BASIC",
			"CAT_MORPH_ADVANCED",
			Race.CAT_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 2),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_CAT_MORPH_CHEETAH,
			SubspeciesPreference.TWO_AVERAGE,
			"An anthropomorphic cheetah, known as a 'cheetah-morph' when bipedal, and a 'cheetahtaur' when the lower body is that of a typically-oversized feral cheetah."
					+ " To be identified as a cheetah-morph, a character must be a cat-morph that has short, spotted fur and not identified as other feline morphs.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.FOUR_COMMON),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), null) {
		@Override
		public void applySpeciesChanges(Body body) {
			Colour primaryColor = PresetColour.COVERING_ORANGE;
			double rand = Math.random();
			if(rand<0.35f) {
				primaryColor = PresetColour.COVERING_TAN;
			}
			Colour secondaryColor = PresetColour.COVERING_BLACK;
			body.getCoverings().put(BodyCoveringType.FELINE_FUR, new Covering(BodyCoveringType.FELINE_FUR, CoveringPattern.SPOTTED, CoveringModifier.SHORT, primaryColor, false, secondaryColor, false));
			body.getCoverings().put(BodyCoveringType.HAIR_FELINE_FUR, new Covering(BodyCoveringType.FELINE_FUR, CoveringPattern.NONE, primaryColor, false, secondaryColor, false));
			body.updateCoverings(true, true, true, true);
			if(body.getTail().getType().getRace()==Race.CAT_MORPH) {
				body.getTail().setType(null, TailType.CAT_MORPH);
			}
			
			// Body size adjustment
			if(body.getBreast().getRawSizeValue()>CupSize.B.getMeasurement()) {
				rand = Math.random();
				if(rand<0.35f) {
					body.getBreast().setSize(null, CupSize.B.getMeasurement());
				} else if(rand<0.70f) {
					body.getBreast().setSize(null, CupSize.A.getMeasurement());
				} else {
					body.getBreast().setSize(null, CupSize.AA.getMeasurement());
				}
			}
			
			body.setBodySize(BodySize.ZERO_SKINNY.getMedianValue());
			body.setMuscle(Muscle.FOUR_RIPPED.getMedianValue());
		}
	},
	
	CAT_MORPH_CARACAL(false,
			"statusEffects/race/raceCatMorph",
			"statusEffects/race/raceBackground",
			"caracal-morph",
			"caracal-morphs",
			"caracal",
			"caracal",
			"caracals",
			"caracals",
			"caracal",
			"[npc.NamePos] body is incredibly agile, and [npc.she] [npc.verb(possess)] lightning reflexes."
					+ " [npc.She] also [npc.has] an instinctive desire to display [npc.her] dominance over innocent harpies and rodent-morphs...",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 5f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 10f),
					new Value<Attribute, Float>(Attribute.DAMAGE_HARPY, 5f),
					new Value<Attribute, Float>(Attribute.DAMAGE_RAT_MORPH, 5f),
					new Value<Attribute, Float>(Attribute.DAMAGE_SQUIRREL_MORPH, 5f)),
			null,
			"Curious Kitties",
			"Curious Kitties",
			"CAT_MORPH_BASIC",
			"CAT_MORPH_ADVANCED",
			Race.CAT_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 2),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_CAT_MORPH_CARACAL,
			SubspeciesPreference.TWO_AVERAGE,
			"An anthropomorphic caracal, known as a 'caracal-morph' when bipedal, and a 'caracaltaur' when the lower body is that of a typically-oversized feral caracal."
					+ " To be identified as a caracal-morph, a character must be a cat-morph with tufted ears.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.FOUR_COMMON),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), null) {
		@Override
		public void applySpeciesChanges(Body body) {
			if(body.getEar().getType().getRace()==Race.CAT_MORPH) {
				body.getEar().setType(null, EarType.CAT_MORPH_TUFTED);
			}
		}
	},

	// EQUINES:
	HORSE_MORPH(true,
			"statusEffects/race/raceHorseMorph",
			"statusEffects/race/raceBackground",
			"horse-morph",
			"horse-morphs",
			"horse-boy",
			"horse-girl",
			"horse-boys",
			"horse-girls",
			"horse",
			"While [npc.namePos] body possesses remarkable strength and speed, [npc.sheIs] not the sharpest tool in the shed, and struggles more than most when it comes to harnessing the arcane.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 25f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, -5f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, -10f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 25f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 25f)),
			null,
			"Equine Encyclopedia",
			"Equine Encyclopedias",
			"HORSE_MORPH_BASIC",
			"HORSE_MORPH_ADVANCED",
			Race.HORSE_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 2),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 10),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_HORSE_MORPH,
			SubspeciesPreference.FOUR_ABUNDANT,
			"An anthropomorphic, bipedal horse.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.FOUR_COMMON),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), null) {
		@Override
		public void applySpeciesChanges(Body body) {
			body.getHorn().setType(null, HornType.NONE);
			body.getWing().setType(null, WingType.NONE);
			if(body.getFace().getType()==FaceType.HORSE_MORPH && (!body.isFeminine() || Math.random()<0.5f)) {
				body.getHair().setStyle(null, HairStyle.NONE); // Sets hair style to mane
			}
		}
		@Override
		public String[] getHalfDemonName(GameCharacter character) {
			String[] names = new String[] {
					"nightmare",
					"nightmares",
					"nightmare",
					"nightmare",
					"nightmares",
					"nightmares"};
			
			if(character!=null && !character.getHalfDemonSubspecies().isNonBiped()) {
				names = new String[] {
					applyNonBipedNameChange(character, "nightmare", false, false),
					applyNonBipedNameChange(character, "nightmare", false, true),
					applyNonBipedNameChange(character, "nightmare", false, false),
					applyNonBipedNameChange(character, "nightmare", true, false),
					applyNonBipedNameChange(character, "nightmare", false, true),
					applyNonBipedNameChange(character, "nightmare", true, true)
				};
			}
			
			return names;
		}
	},
	HORSE_MORPH_UNICORN(false,
			"statusEffects/race/raceHorseMorph",
			"statusEffects/race/raceBackground",
			"unicorn-morph",
			"unicorn-morphs",
			"unicorn-boy",
			"unicorn-girl",
			"unicorn-boys",
			"unicorn-girls",
			"unicorn",
			"Although physically weaker than a regular horse-morph, [npc.nameHasFull] a special bond with the arcane, and [npc.is] able to cast many spells before exhausting [npc.her] aura.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 20f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 5f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, 50f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 5f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 10f)),
			null,
			"Equine Encyclopedia",
			"Equine Encyclopedias",
			"HORSE_MORPH_BASIC",
			"HORSE_MORPH_ADVANCED",
			Race.HORSE_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 3),
					new Value<>(PerkCategory.LUST, 2),
					new Value<>(PerkCategory.ARCANE, 3)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 4),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 3)),
			PresetColour.RACE_UNICORN,
			SubspeciesPreference.ONE_LOW,
			"An anthropomorphic, bipedal horse, who has a single magical horn growing from their forehead.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.ONE_VERY_RARE),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.ONE_VERY_RARE)), null) {
		@Override
		public void applySpeciesChanges(Body body) {
			body.getHorn().setType(null, HornType.HORSE_STRAIGHT);
			body.getHorn().setHornRows(null, 1);
			body.getHorn().setHornsPerRow(null, 1);
			body.getHorn().setHornLength(null, HornLength.TWO_LONG.getMedianValue());
			body.getWing().setType(null, WingType.NONE);
			if(body.getFace().getType()==FaceType.HORSE_MORPH && (!body.isFeminine() || Math.random()<0.5f)) {
				body.getHair().setStyle(null, HairStyle.NONE); // Sets hair style to mane
			}
		}
		@Override
		public String[] getHalfDemonName(GameCharacter character) {
			String[] names = new String[] {
					"unicorn-nightmare",
					"unicorn-nightmares",
					"unicorn-nightmare",
					"unicorn-nightmare",
					"unicorn-nightmares",
					"unicorn-nightmares"};
			
			if(character!=null && !character.getHalfDemonSubspecies().isNonBiped()) {
				names = new String[] {
					applyNonBipedNameChange(character, "unicorn-nightmare", false, false),
					applyNonBipedNameChange(character, "unicorn-nightmare", false, true),
					applyNonBipedNameChange(character, "unicorn-nightmare", false, false),
					applyNonBipedNameChange(character, "unicorn-nightmare", true, false),
					applyNonBipedNameChange(character, "unicorn-nightmare", false, true),
					applyNonBipedNameChange(character, "unicorn-nightmare", true, true)
				};
			}
			
			return names;
		}
	},
	HORSE_MORPH_PEGASUS(false,
			"statusEffects/race/raceHorseMorph",
			"statusEffects/race/raceBackground",
			"pegasus-morph",
			"pegasus-morphs",
			"pegasus-boy",
			"pegasus-girl",
			"pegasus-boys",
			"pegasus-girls",
			"pegasus",
			"Although physically weaker than a regular horse-morph, [npc.nameIsFull] a lot more agile, allowing [npc.herHim] to avoid incoming damage.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 15f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 10f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 10f)),
			null,
			"Equine Encyclopedia",
			"Equine Encyclopedias",
			"HORSE_MORPH_BASIC",
			"HORSE_MORPH_ADVANCED",
			Race.HORSE_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_PEGASUS,
			SubspeciesPreference.ONE_LOW,
			"An anthropomorphic, bipedal horse, who has a pair of feathered wings growing from their back.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.ONE_VERY_RARE),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.ONE_VERY_RARE)), null) {
		@Override
		public void applySpeciesChanges(Body body) {
			body.getHorn().setType(null, HornType.NONE);
			body.setWing(new Wing(WingType.FEATHERED, WingSize.THREE_LARGE.getValue()));
			if(body.getFace().getType()==FaceType.HORSE_MORPH && (!body.isFeminine() || Math.random()<0.5f)) {
				body.getHair().setStyle(null, HairStyle.NONE); // Sets hair style to mane
			}
		}
		@Override
		public String[] getHalfDemonName(GameCharacter character) {
			String[] names = new String[] {
					"pegasus-nightmare",
					"pegasus-nightmares",
					"pegasus-nightmare",
					"pegasus-nightmare",
					"pegasus-nightmares",
					"pegasus-nightmares"};
			
			if(character!=null && !character.getHalfDemonSubspecies().isNonBiped()) {
				names = new String[] {
					applyNonBipedNameChange(character, "pegasus-nightmare", false, false),
					applyNonBipedNameChange(character, "pegasus-nightmare", false, true),
					applyNonBipedNameChange(character, "pegasus-nightmare", false, false),
					applyNonBipedNameChange(character, "pegasus-nightmare", true, false),
					applyNonBipedNameChange(character, "pegasus-nightmare", false, true),
					applyNonBipedNameChange(character, "pegasus-nightmare", true, true)
				};
			}
			
			return names;
		}
	},
	HORSE_MORPH_ALICORN(false,
			"statusEffects/race/raceHorseMorph",
			"statusEffects/race/raceBackground",
			"alicorn-morph",
			"alicorn-morphs",
			"alicorn-boy",
			"alicorn-girl",
			"alicorn-boys",
			"alicorn-girls",
			"alicorn",
			"Possessing both feathered wings and a unicorn horn, [npc.nameIsFull] classified as a powerful alicorn, and [npc.verb(find)] it almost effortlessly trivial to cast spells.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 15f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 15f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, 75f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 10f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 50f)),
			null,
			"Equine Encyclopedia",
			"Equine Encyclopedias",
			"HORSE_MORPH_BASIC",
			"HORSE_MORPH_ADVANCED",
			Race.HORSE_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 3)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 3)),
			PresetColour.RACE_ALICORN,
			SubspeciesPreference.ONE_LOW,
			"An anthropomorphic, bipedal horse, who has both a pair of feathered wings growing from their back, as well as a single magical horn growing from their forehead.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.ZERO_EXTREMELY_RARE),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.ZERO_EXTREMELY_RARE)), null) {
		@Override
		public void applySpeciesChanges(Body body) {
			body.getHorn().setType(null, HornType.HORSE_STRAIGHT);
			body.getHorn().setHornRows(null, 1);
			body.getHorn().setHornsPerRow(null, 1);
			body.getHorn().setHornLength(null, HornLength.TWO_LONG.getMedianValue());
			body.setWing(new Wing(WingType.FEATHERED, WingSize.THREE_LARGE.getValue()));
			if(body.getFace().getType()==FaceType.HORSE_MORPH && (!body.isFeminine() || Math.random()<0.5f)) {
				body.getHair().setStyle(null, HairStyle.NONE); // Sets hair style to mane
			}
		}
		@Override
		public String[] getHalfDemonName(GameCharacter character) {
			String[] names = new String[] {
					"alicorn-nightmare",
					"alicorn-nightmares",
					"alicorn-nightmare",
					"alicorn-nightmare",
					"alicorn-nightmares",
					"alicorn-nightmares"};
			
			if(character!=null && !character.getHalfDemonSubspecies().isNonBiped()) {
				names = new String[] {
					applyNonBipedNameChange(character, "alicorn-nightmare", false, false),
					applyNonBipedNameChange(character, "alicorn-nightmare", false, true),
					applyNonBipedNameChange(character, "alicorn-nightmare", false, false),
					applyNonBipedNameChange(character, "alicorn-nightmare", true, false),
					applyNonBipedNameChange(character, "alicorn-nightmare", false, true),
					applyNonBipedNameChange(character, "alicorn-nightmare", true, true)
				};
			}
			
			return names;
		}
	},
	
	CENTAUR(false,
			"statusEffects/race/raceHorseMorph",
			"statusEffects/race/raceBackground",
			"centaur",
			"centaurs",
			"centaur",
			"centauress",
			"centaurs",
			"centauresses",
			"horse",
			"Thanks to having the lower body of a horse, [npc.nameIsFull] capable of running at great speed, and [npc.is] also capable of dealing significant physical damage.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 35f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, -5f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, -10f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 25f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 50f)),
			null,
			"Equine Encyclopedia",
			"Equine Encyclopedias",
			"CENTAUR_BASIC",
			"CENTAUR_ADVANCED",
			Race.HORSE_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 2),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_CENTAUR,
			SubspeciesPreference.FOUR_ABUNDANT,
			"Anyone who has the feral, quadrupedal lower body of a horse is classified as a centaur.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.ONE_VERY_RARE),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.ONE_VERY_RARE)), null) { //TODO add to fields
		@Override
		public boolean isNonBiped() {
			return true;
		}
		@Override
		public void applySpeciesChanges(Body body) {
			body.getHorn().setType(null, HornType.NONE);
			body.getWing().setType(null, WingType.NONE);
			body.getLeg().setType(null, LegType.HORSE_MORPH);
			LegType.HORSE_MORPH.applyLegConfigurationTransformation(body, LegConfiguration.TAUR, true);
			if(body.getFace().getType()==FaceType.HORSE_MORPH && (!body.isFeminine() || Math.random()<0.5f)) {
				body.getHair().setStyle(null, HairStyle.NONE); // Sets hair style to mane
			}
		}
		@Override
		public String[] getHalfDemonName(GameCharacter character) {
			return new String[] {
					"demonic-centaur",
					"demonic-centaurs",
					"demonic-centaur",
					"demonic-centauress",
					"demonic-centaurs",
					"demonic-centauresses"};
		}
	},
	PEGATAUR(false,
			"statusEffects/race/raceHorseMorph",
			"statusEffects/race/raceBackground",
			"pegataur",
			"pegataurs",
			"pegataur",
			"pegatauress",
			"pegataurs",
			"pegatauresses",
			"horse",
			"Although physically weaker than a regular centaur, [npc.nameIsFull] a lot more agile, allowing [npc.herHim] to avoid incoming damage.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 30f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 5f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 10f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 10f)),
			null,
			"Equine Encyclopedia",
			"Equine Encyclopedias",
			"CENTAUR_BASIC",
			"CENTAUR_ADVANCED",
			Race.HORSE_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_PEGATAUR,
			SubspeciesPreference.ONE_LOW,
			"Anyone who has the feral, winged, quadrupedal lower body of a horse is classified as a pegataur.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.ZERO_EXTREMELY_RARE),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.ZERO_EXTREMELY_RARE)), null) { //TODO add to fields
		@Override
		public boolean isNonBiped() {
			return true;
		}
		@Override
		public void applySpeciesChanges(Body body) {
			body.getHorn().setType(null, HornType.NONE);
			body.getLeg().setType(null, LegType.HORSE_MORPH);
			LegType.HORSE_MORPH.applyLegConfigurationTransformation(body, LegConfiguration.TAUR, true);
			body.setWing(new Wing(WingType.FEATHERED, WingSize.FOUR_HUGE.getValue()));
			if(body.getFace().getType()==FaceType.HORSE_MORPH && (!body.isFeminine() || Math.random()<0.5f)) {
				body.getHair().setStyle(null, HairStyle.NONE); // Sets hair style to mane
			}
			
		}
		@Override
		public String[] getHalfDemonName(GameCharacter character) {
			return new String[] {
					"demonic-pegataur",
					"demonic-pegataurs",
					"demonic-pegataur",
					"demonic-pegatauress",
					"demonic-pegataurs",
					"demonic-pegatauresses"};
		}
	},
	UNITAUR(false,
			"statusEffects/race/raceHorseMorph",
			"statusEffects/race/raceBackground",
			"unitaur",
			"unitaurs",
			"unitaur",
			"unitauress",
			"unitaurs",
			"unitauresses",
			"horse",
			"Although physically weaker than a regular horse-morph, [npc.nameHasFull] a special bond with the arcane, and [npc.is] able to cast many spells before exhausting [npc.her] aura.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 25f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, 50f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 5f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 10f)),
			null,
			"Equine Encyclopedia",
			"Equine Encyclopedias",
			"CENTAUR_BASIC",
			"CENTAUR_ADVANCED",
			Race.HORSE_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 1)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 1)),
			PresetColour.RACE_UNICORN,
			SubspeciesPreference.ONE_LOW,
			"Anyone who has the feral, quadrupedal lower body of a horse, along with a single unicorn horn, is classified as a unitaur.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.ZERO_EXTREMELY_RARE),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.ZERO_EXTREMELY_RARE)), null) { //TODO add to fields
		@Override
		public boolean isNonBiped() {
			return true;
		}
		@Override
		public void applySpeciesChanges(Body body) {
			body.getHorn().setType(null, HornType.HORSE_STRAIGHT);
			body.getHorn().setHornRows(null, 1);
			body.getHorn().setHornsPerRow(null, 1);
			body.getHorn().setHornLength(null, HornLength.TWO_LONG.getMedianValue());
			body.getLeg().setType(null, LegType.HORSE_MORPH);
			LegType.HORSE_MORPH.applyLegConfigurationTransformation(body, LegConfiguration.TAUR, true);
			body.getWing().setType(null, WingType.NONE);
			if(body.getFace().getType()==FaceType.HORSE_MORPH && (!body.isFeminine() || Math.random()<0.5f)) {
				body.getHair().setStyle(null, HairStyle.NONE); // Sets hair style to mane
			}
		}
		@Override
		public String[] getHalfDemonName(GameCharacter character) {
			return new String[] {
					"demonic-unitaur",
					"demonic-unitaurs",
					"demonic-unitaur",
					"demonic-unitauress",
					"demonic-unitaurs",
					"demonic-unitauresses"};
		}
	},
	ALITAUR(false,
			"statusEffects/race/raceHorseMorph",
			"statusEffects/race/raceBackground",
			"alitaur",
			"alitaurs",
			"alitaur",
			"alitauress",
			"alitaurs",
			"alitauresses",
			"horse",
			"Possessing both feathered wings and a unicorn horn, [npc.nameIsFull] classified as a powerful alicorn, and [npc.verb(find)] it almost effortlessly trivial to cast spells.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 25f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 15f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, 75f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 10f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 50f)),
			null,
			"Equine Encyclopedia",
			"Equine Encyclopedias",
			"CENTAUR_BASIC",
			"CENTAUR_ADVANCED",
			Race.HORSE_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 2)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 2)),
			PresetColour.RACE_ALICORN,
			SubspeciesPreference.ONE_LOW,
			"Anyone who has the feral, winged, quadrupedal lower body of a horse, along with a single unicorn horn, is classified as an alitaur.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.ZERO_EXTREMELY_RARE),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.ZERO_EXTREMELY_RARE)), null) { //TODO add to fields
		@Override
		public boolean isNonBiped() {
			return true;
		}
		@Override
		public void applySpeciesChanges(Body body) {
			body.getHorn().setType(null, HornType.HORSE_STRAIGHT);
			body.getHorn().setHornRows(null, 1);
			body.getHorn().setHornsPerRow(null, 1);
			body.getHorn().setHornLength(null, HornLength.TWO_LONG.getMedianValue());
			body.getLeg().setType(null, LegType.HORSE_MORPH);
			LegType.HORSE_MORPH.applyLegConfigurationTransformation(body, LegConfiguration.TAUR, true);
			body.setWing(new Wing(WingType.FEATHERED, WingSize.FOUR_HUGE.getValue()));
			if(body.getFace().getType()==FaceType.HORSE_MORPH && (!body.isFeminine() || Math.random()<0.5f)) {
				body.getHair().setStyle(null, HairStyle.NONE); // Sets hair style to mane
			}
		}
		@Override
		public String[] getHalfDemonName(GameCharacter character) {
			return new String[] {
					"demonic-alitaur",
					"demonic-alitaurs",
					"demonic-alitaur",
					"demonic-alitauress",
					"demonic-alitaurs",
					"demonic-alitauresses"};
		}
	},

	HORSE_MORPH_ZEBRA(false,
			"statusEffects/race/raceHorseMorphZebra",
			"statusEffects/race/raceBackgroundZebra",
			"zebra-morph",
			"zebra-morphs",
			"zebra-boy",
			"zebra-girl",
			"zebra-boys",
			"zebra-girls",
			"zebra",
			"While [npc.namePos] body possesses an impressive level of both strength and speed, [npc.sheIs] not the sharpest tool in the shed, and struggles more than most when it comes to harnessing the arcane."
					+ " [npc.She] also [npc.has] a high resistance to both natural and arcane heat.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 25f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, -5f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, -10f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 10f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 20f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_FIRE, 5f)),
			null,
			"Equine Encyclopedia",
			"Equine Encyclopedias",
			"HORSE_MORPH_BASIC",
			"HORSE_MORPH_ADVANCED",
			Race.HORSE_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 2),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 10),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.BASE_BLACK,
			SubspeciesPreference.ONE_LOW,
			"An anthropomorphic horse with black-and-white striped fur, known as a 'zebra-morph' when bipedal, and a 'zebrataur' when the lower body is that of a feral zebra."
				+" To be identified as a zebra-morph, a character must be a horse-morph that has black-and-white striped hair, with a zebra-morph's tail.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.FOUR_COMMON),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), null) {
		@Override
		public void applySpeciesChanges(Body body) {
			body.getHorn().setType(null, HornType.NONE);
			body.getWing().setType(null, WingType.NONE);
			body.getCoverings().put(BodyCoveringType.HORSE_HAIR, new Covering(BodyCoveringType.HORSE_HAIR, CoveringPattern.STRIPED, CoveringModifier.SHORT, PresetColour.COVERING_BLACK, false, PresetColour.COVERING_WHITE, false));
			body.getCoverings().put(BodyCoveringType.HAIR_HORSE_HAIR, new Covering(BodyCoveringType.HAIR_HORSE_HAIR, CoveringPattern.NONE, PresetColour.COVERING_BLACK, false, PresetColour.COVERING_WHITE, false));
			body.getCoverings().put(BodyCoveringType.HUMAN, new Covering(BodyCoveringType.HUMAN, CoveringPattern.NONE, PresetColour.SKIN_EBONY, false, PresetColour.SKIN_EBONY, false));
			body.updateCoverings(true, true, true, true);
			
			if(body.getTail().getType()==TailType.HORSE_MORPH) {
				body.getTail().setType(null, TailType.HORSE_MORPH_ZEBRA);
			}
			if(body.getFace().getType()==FaceType.HORSE_MORPH && (!body.isFeminine() || Math.random()<0.5f)) {
				body.getHair().setStyle(null, HairStyle.NONE); // Sets hair style to mane
			}
		}
		@Override
		public String[] getHalfDemonName(GameCharacter character) {
			String[] names = new String[] {
					"nightmare",
					"nightmares",
					"nightmare",
					"nightmare",
					"nightmares",
					"nightmares"};
			
			if(character!=null && !character.getHalfDemonSubspecies().isNonBiped()) {
				names = new String[] {
					applyNonBipedNameChange(character, "nightmare", false, false),
					applyNonBipedNameChange(character, "nightmare", false, true),
					applyNonBipedNameChange(character, "nightmare", false, false),
					applyNonBipedNameChange(character, "nightmare", true, false),
					applyNonBipedNameChange(character, "nightmare", false, true),
					applyNonBipedNameChange(character, "nightmare", true, true)
				};
			}
			
			return names;
		}
	},

	REINDEER_MORPH(true,
			"statusEffects/race/raceReindeerMorph",
			"statusEffects/race/raceBackground",
			"reindeer-morph",
			"reindeer-morphs",
			"reindeer-boy",
			"reindeer-girl",
			"reindeer-boys",
			"reindeer-girls",
			"reindeer",
			"[npc.NamePos] body is very well suited to resisting both natural and arcane cold, and is also particularly strong and hardy.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 25f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 10f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_PHYSICAL, 2f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_ICE, 5f)),
			null,
			"One Who Paws",
			"One Who Paws'",
			"REINDEER_MORPH_BASIC",
			"REINDEER_MORPH_ADVANCED",
			Race.REINDEER_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 2),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 10),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_REINDEER_MORPH,
			SubspeciesPreference.FOUR_ABUNDANT,
			"An anthropomorphic reindeer, known as a 'reindeer-morph' when bipedal, and a 'reindeertaur' when the lower body is that of a feral reindeer.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.FOUR_COMMON),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), null),
	
	// REPTILE:
	ALLIGATOR_MORPH(true,
			"statusEffects/race/raceGatorMorph",
			"statusEffects/race/raceBackground",
			"alligator-morph",
			"alligator-morphs",
			"alligator-boy",
			"alligator-girl",
			"alligator-boys",
			"alligator-girls",
			"alligator",
			"[npc.NamePos] body is incredibly tough, and [npc.she] [npc.verb(possess)] lightning reflexes, as well as the strength required to make the most of any sudden attacks.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 30f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 10f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 25f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_PHYSICAL, 5f)),
			null,
			"Rasselin' Gators",
			"Rasselin' Gators",
			"ALLIGATOR_MORPH_BASIC",
			"ALLIGATOR_MORPH_ADVANCED",
			Race.ALLIGATOR_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 10),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_ALLIGATOR_MORPH,
			SubspeciesPreference.FOUR_ABUNDANT,
			"An anthropomorphic alligator, known as an 'alligator-morph' when bipedal, and an 'alligatortaur' when the lower body is that of a typically-oversized feral alligator.", Util.newHashMapOfValues(
							new Value<>(WorldType.SUBMISSION, SubspeciesSpawnRarity.FOUR_COMMON),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.ONE_VERY_RARE)), null),
	
	//LIZARD_MORPH(Race.LIZARD_MORPH.getName(), Race.LIZARD_MORPH, RacialBody.LIZARD_MORPH, SubspeciesPreference.FIVE_ABUNDANT,
	//		"A typical bipedal "+Race.LIZARD_MORPH.getName()),
	//LAMIA(Race.LAMIA.getName(), Race.LIZARD_MORPH, RacialBody.LAMIA, SubspeciesPreference.TWO_LOW,
	//		"A "+Race.LIZARD_MORPH.getName()+" with a serpentine lower body, devoid of legs"),
	
	// AQUATIC:
	//SHARK_MORPH(Race.SHARK_MORPH.getName(), Race.SHARK_MORPH, RacialBody.SHARK_MORPH, SubspeciesPreference.FIVE_ABUNDANT,
	//		"A typical bipedal "+Race.SHARK_MORPH.getName()),
	//TIGER_SHARK(Race.TIGER_SHARK.getName(), Race.TIGER_SHARK, RacialBody.TIGER_SHARK, SubspeciesPreference.FIVE_ABUNDANT,
	//		"An extremely aggressive variety of "+Race.SHARK_MORPH.getName()),
	
	// INSECTS:
	//BEE_MORPH(Race.BEE_MORPH.getName(), Race.BEE_MORPH, RacialBody.BEE_MORPH, SubspeciesPreference.FIVE_ABUNDANT,
	//		"A typical bipedal "+Race.BEE_MORPH.getName()),
	//ROYAL_BEE(Race.ROYAL_BEE.getName(), Race.BEE_MORPH, RacialBody.ROYAL_BEE, SubspeciesPreference.ZERO_NONE,
	//		"A bipedal "+Race.BEE_MORPH.getName()+" at the top of the bee-morph hierarchy"),
	//WASP_MORPH(Race.WASP_MORPH.getName(), Race.WASP_MORPH, RacialBody.WASP_MORPH, SubspeciesPreference.FIVE_ABUNDANT,
	//		"A typical bipedal "+Race.WASP_MORPH.getName()),
	
	// ARACHNIDS:
	//SPIDER_MORPH(Race.SPIDER_MORPH.getName(), Race.SPIDER_MORPH, RacialBody.SPIDER_MORPH, SubspeciesPreference.FIVE_ABUNDANT,
	//		"A typical bipedal "+Race.SPIDER_MORPH.getName()),
	//ARACHNE(Race.ARACHNE.getName(), Race.SPIDER_MORPH, RacialBody.ARACHNE, SubspeciesPreference.TWO_LOW,
	//		"A "+Race.SPIDER_MORPH.getName()+" with an arachnid lower body that walks on eight legs"),
			
	// DRAGONS:
	//DRAGON(Race.DRAGON.getName(), Race.DRAGON, RacialBody.DRAGON, SubspeciesPreference.FOUR_HIGH,
	//		"A typical bipedal "+Race.DRAGON.getName()),
	//DRAGON_FUR("Fur "+Race.DRAGON.getName(), Race.DRAGON, RacialBody.DRAGON_FUR, SubspeciesPreference.ZERO_NONE,
	//		"A "+Race.DRAGON.getName()+" with a thick coat of fur, rather than scales"),
	//WYVERN(Race.WYVERN.getName(), Race.DRAGON, RacialBody.WYVERN, SubspeciesPreference.ONE_MINIMAL,
	//		"A bipedal "+Race.DRAGON.getName()+" with arms that act as wings"),
	//WYRM(Race.WYRM.getName(), Race.DRAGON, RacialBody.WYRM, SubspeciesPreference.ONE_MINIMAL,
	//		"A "+Race.DRAGON.getName()+" with a serpentine lower body, devoid of legs"),
	
	// SLIMES:
	SLIME(true,
			"statusEffects/race/raceSlime",
			"statusEffects/race/raceBackgroundSlime",
			"slime",
			"slimes",
			"slime-boy",
			"slime-girl",
			"slime-boys",
			"slime-girls",
			"slime",
			"Due to [npc.her] soft, slimy body, [npc.nameIsFull] almost completely immune to physical damage, but [npc.she] is also unable to inflict any significant damage while unarmed."
					+ " [npc.She] can also morph [npc.her] body at will, allowing [npc.herHim] to take on any form that [npc.she] [npc.verb(desire)].",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 25f)),
			Util.newArrayListOfValues(),
			"Slimy Fun",
			"Slimy Funs",
			"SLIME_BASIC",
			"SLIME_ADVANCED",
			Race.SLIME,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 2),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_SLIME,
			SubspeciesPreference.FOUR_ABUNDANT,
			"Someone who is made completely of slime, with a sold core suspended in the place where their heart should be.",
			Util.newHashMapOfValues(
					new Value<>(WorldType.SUBMISSION, SubspeciesSpawnRarity.FOUR_COMMON),
					new Value<>(WorldType.BAT_CAVERNS, SubspeciesSpawnRarity.FOUR_COMMON)), Util.newArrayListOfValues(
					SubspeciesFlag.HIDDEN_FROM_PREFERENCES)) {
		@Override
		public void applySpeciesChanges(Body body) {
			// Slime subspecies are set in the CharacterUtils.generateBody() method
			body.setBodyMaterial(BodyMaterial.SLIME);
		}

		@Override
		public String getStatusEffectDescription(GameCharacter character) {
			if(character!=null) {
				Subspecies coreSubspecies = Subspecies.getFleshSubspecies(character);
				if(character.getSubspeciesOverrideRace()==Race.DEMON) {
					return UtilText.parse(character,
							"Due to [npc.her] soft, slimy body, [npc.nameIsFull] almost completely immune to physical damage, but [npc.she] is also unable to inflict any serious unarmed damage."
							+ " [npc.Her] slime core is pulsating with an immense power, revealing the fact that [npc.sheIs] a true demonic slime.");
				} else if(coreSubspecies==Subspecies.DEMON) {
					return UtilText.parse(character,
							"Due to [npc.her] soft, slimy body, [npc.nameIsFull] almost completely immune to physical damage, but [npc.she] is also unable to inflict any serious unarmed damage."
							+ " Although [npc.she] [npc.verb(appear)] to be a demon, [npc.sheIs] just mimicking their appearance...");
				}
			}
			return super.getStatusEffectDescription(character);
		}
		
		@Override
		public String getName(GameCharacter character) {
			if(character==null) {
				return super.getName(character);
			}
			Subspecies coreSubspecies = Subspecies.getFleshSubspecies(character);
			if(coreSubspecies==Subspecies.HUMAN) {
				return super.getName(character);
			} else if(coreSubspecies==Subspecies.DEMON && character.getSubspeciesOverride()==null) {
				return coreSubspecies.getName(character)+"-mimic-slime";
			}
			return coreSubspecies.getName(character)+"-slime";
		}
		
		@Override
		public String getNamePlural(GameCharacter character) {
			if(character==null) {
				return super.getNamePlural(character);
			}
			Subspecies coreSubspecies = Subspecies.getFleshSubspecies(character);
			if(coreSubspecies==Subspecies.HUMAN) {
				return super.getNamePlural(character);
			} else if(coreSubspecies==Subspecies.DEMON && character.getSubspeciesOverride()==null) {
				return coreSubspecies.getName(character)+"-mimic-slimes";
			}
			return coreSubspecies.getName(character)+"-slimes";
		}

		@Override
		public String getSingularMaleName(GameCharacter character) {
			if(character==null) {
				return super.getSingularMaleName(character);
			}
			Subspecies coreSubspecies = Subspecies.getFleshSubspecies(character);
			if(coreSubspecies==Subspecies.HUMAN) {
				return super.getSingularMaleName(character);
			} else if(coreSubspecies==Subspecies.DEMON && character.getSubspeciesOverride()==null) {
				return coreSubspecies.getSingularMaleName(character)+"-mimic-slime";
			}
			return coreSubspecies.getSingularMaleName(character)+"-slime";
		}

		@Override
		public String getSingularFemaleName(GameCharacter character) {
			if(character==null) {
				return super.getSingularFemaleName(character);
			}
			Subspecies coreSubspecies = Subspecies.getFleshSubspecies(character);
			if(coreSubspecies==Subspecies.HUMAN) {
				return super.getSingularFemaleName(character);
			} else if(coreSubspecies==Subspecies.DEMON && character.getSubspeciesOverride()==null) {
				return coreSubspecies.getSingularFemaleName(character)+"-mimic-slime";
			}
			return coreSubspecies.getSingularFemaleName(character)+"-slime";
		}

		@Override
		public String getPluralMaleName(GameCharacter character) {
			if(character==null) {
				return super.getPluralMaleName(character);
			}
			Subspecies coreSubspecies = Subspecies.getFleshSubspecies(character);
			if(coreSubspecies==Subspecies.HUMAN) {
				return super.getPluralMaleName(character);
			} else if(coreSubspecies==Subspecies.DEMON && character.getSubspeciesOverride()==null) {
				return coreSubspecies.getSingularMaleName(character)+"-mimic-slimes";
			}
			return coreSubspecies.getSingularMaleName(character)+"-slimes";
		}

		@Override
		public String getPluralFemaleName(GameCharacter character) {
			if(character==null) {
				return super.getPluralFemaleName(character);
			}
			Subspecies coreSubspecies = Subspecies.getFleshSubspecies(character);
			if(coreSubspecies==Subspecies.HUMAN) {
				return super.getPluralFemaleName(character);
			} else if(coreSubspecies==Subspecies.DEMON && character.getSubspeciesOverride()==null) {
				return coreSubspecies.getSingularFemaleName(character)+"-mimic-slimes";
			}
			return coreSubspecies.getSingularFemaleName(character)+"-slimes";
		}

		@Override
		public String getSVGString(GameCharacter character) {
			if(character==null) {
				return Subspecies.HUMAN.getSlimeSVGString(null);
			}
			return Subspecies.getFleshSubspecies(character).getSlimeSVGString(character);
		}

		@Override
		public String getSVGStringDesaturated(GameCharacter character) {
			if(character==null) {
				return Subspecies.HUMAN.getSVGStringDesaturated(null);
			}
			return Subspecies.getFleshSubspecies(character).getSVGStringDesaturated(character);
		}
	},
	
//	
//	// GARGOYLES:
//	GARGOYLE(Race.GARGOYLE.getName(), Race.GARGOYLE, RacialBody.GARGOYLE, SubspeciesPreference.FIVE_ABUNDANT,
//			"A typical "+Race.GARGOYLE.getName()),
//	GARGOYLE_CAT(Race.CAT_MORPH.getName()+" "+Race.GARGOYLE.getName(), Race.GARGOYLE, RacialBody.GARGOYLE_CAT, SubspeciesPreference.TWO_LOW,
//			"A "+Race.GARGOYLE.getName()+" resembling a typical bipedal "+Race.CAT_MORPH.getName()),
//	GARGOYLE_DOG(Race.DOG_MORPH.getName()+" "+Race.GARGOYLE.getName(), Race.GARGOYLE, RacialBody.GARGOYLE_DOG, SubspeciesPreference.TWO_LOW,
//			"A "+Race.GARGOYLE.getName()+" resembling a typical bipedal "+Race.DOG_MORPH.getName()),
//	GARGOYLE_WOLF(Race.WOLF_MORPH.getName()+" "+Race.GARGOYLE.getName(), Race.GARGOYLE, RacialBody.GARGOYLE_WOLF, SubspeciesPreference.TWO_LOW,
//			"A "+Race.GARGOYLE.getName()+" resembling a typical bipedal "+Race.WOLF_MORPH.getName()),
//	GARGOYLE_HORSE(Race.HORSE_MORPH.getName()+" "+Race.GARGOYLE.getName(), Race.GARGOYLE, RacialBody.GARGOYLE_HORSE, SubspeciesPreference.TWO_LOW,
//			"A "+Race.GARGOYLE.getName()+" resembling a typical bipedal "+Race.HORSE_MORPH.getName()),

	// RODENTS:
	SQUIRREL_MORPH(true,
			"statusEffects/race/raceSquirrelMorph",
			"statusEffects/race/raceBackground",
			"squirrel-morph",
			"squirrel-morphs",
			"squirrel-boy",
			"squirrel-girl",
			"squirrel-boys",
			"squirrel-girls",
			"squirrel",
			"[npc.NameIsFull] very agile and alert, and [npc.is] capable of leaping great distances with [npc.her] powerful [npc.legs].",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.ENERGY_SHIELDING, 1f)),
			null,
			"Chasing Squirrels",
			"Chasing Squirrels'",
			"SQUIRREL_MORPH_BASIC",
			"SQUIRREL_MORPH_ADVANCED",
			Race.SQUIRREL_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 2),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_SQUIRREL_MORPH,
			SubspeciesPreference.FOUR_ABUNDANT,
			"An anthropomorphic squirrel, known as a 'squirrel-morph' when bipedal, and a 'squirreltaur' when the lower body is that of an oversized feral squirrel.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.FOUR_COMMON),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), null),
	
	//MOUSE_MORPH(Race.MOUSE_MORPH.getName(), Race.MOUSE_MORPH, RacialBody.MOUSE_MORPH, SubspeciesPreference.FIVE_ABUNDANT,
	//		"A typical bipedal "+Race.MOUSE_MORPH.getName()),
	
	RAT_MORPH(true,
			"statusEffects/race/raceRatMorph",
			"statusEffects/race/raceBackground",
			"rat-morph",
			"rat-morphs",
			"rat-boy",
			"rat-girl",
			"rat-boys",
			"rat-girls",
			"rat",
			"[npc.NamePos] body is very hardy, and [npc.she] [npc.has] both a high resistance to, and affinity with, arcane poison.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 10f),
					new Value<Attribute, Float>(Attribute.DAMAGE_POISON, 15f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_POISON, 5f)),
			null,
			"Causing Mischief",
			"Causing Mischiefs",
			"RAT_MORPH_BASIC",
			"RAT_MORPH_ADVANCED",
			Race.RAT_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 2),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_RAT_MORPH,
			SubspeciesPreference.FOUR_ABUNDANT,
			"An anthropomorphic rat, known as a 'rat-morph' when bipedal, and a 'rat-taur' when the lower body is that of an oversized feral rat.", Util.newHashMapOfValues(
							new Value<>(WorldType.SUBMISSION, SubspeciesSpawnRarity.FOUR_COMMON),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.ONE_VERY_RARE)), null),

	RABBIT_MORPH(true,
			"statusEffects/race/raceRabbitMorph",
			"statusEffects/race/raceBackground",
			"rabbit-morph",
			"rabbit-morphs",
			"rabbit-boy",
			"rabbit-girl",
			"rabbit-boys",
			"rabbit-girls",
			"rabbit",
			"[npc.NameIsFull] very agile and alert, and [npc.is] capable of short bursts of incredible speed."
					+ " [npc.Her] body, whether [npc.she] [npc.verb(like)] it or not, is also adapted for producing as many offspring as possible.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 5f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 5f),
					new Value<Attribute, Float>(Attribute.FERTILITY, 50f),
					new Value<Attribute, Float>(Attribute.VIRILITY, 50f)),
			null,
			"Bunny Litters",
			"Bunny Litters'",
			"RABBIT_MORPH_BASIC",
			"RABBIT_MORPH_ADVANCED",
			Race.RABBIT_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 2),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_RABBIT_MORPH,
			SubspeciesPreference.FOUR_ABUNDANT,
			"An anthropomorphic rabbit, known as a 'rabbit-morph' when bipedal, and a 'rabbit-taur' when the lower body is that of an oversized feral rabbit.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.FOUR_COMMON),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), null) { //TODO move to fields
		@Override
		public String[] getHalfDemonName(GameCharacter character) {
			String[] names = new String[] {
					"jackalope",
					"jackalopes",
					"jackalope",
					"jackalope",
					"jackalopes",
					"jackalopes"};
			
			if(character!=null && !character.getHalfDemonSubspecies().isNonBiped()) {
				names = new String[] {
					applyNonBipedNameChange(character, "jackalope", false, false),
					applyNonBipedNameChange(character, "jackalope", false, true),
					applyNonBipedNameChange(character, "jackalope", false, false),
					applyNonBipedNameChange(character, "jackalope", true, false),
					applyNonBipedNameChange(character, "jackalope", false, true),
					applyNonBipedNameChange(character, "jackalope", true, true)
				};
			}
			
			return names;
		}
	},

	RABBIT_MORPH_LOP(false,
			"statusEffects/race/raceRabbitLopMorph",
			"statusEffects/race/raceBackground",
			"lop-rabbit-morph",
			"lop-rabbit-morphs",
			"lop-rabbit-boy",
			"lop-rabbit-girl",
			"lop-rabbit-boys",
			"lop-rabbit-girls",
			"lop-rabbit",
			"[npc.NameIsFull] very agile and alert, and [npc.is] capable of short bursts of incredible speed."
					+ " [npc.Her] body, whether [npc.she] [npc.verb(like)] it or not, is also adapted for producing as many offspring as possible.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 5f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 5f),
					new Value<Attribute, Float>(Attribute.FERTILITY, 50f),
					new Value<Attribute, Float>(Attribute.VIRILITY, 50f)),
			null,
			"Bunny Litters",
			"Bunny Litters'",
			"RABBIT_MORPH_BASIC",
			"RABBIT_MORPH_ADVANCED",
			Race.RABBIT_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 2),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_RABBIT_MORPH,
			SubspeciesPreference.FOUR_ABUNDANT,
			"An anthropomorphic rabbit which has floppy ears instead of the usual upright ones. Known as a 'lop-rabbit-morph' when bipedal, and a 'lop-rabbit-taur' when the lower body is that of an oversized feral lop-rabbit.", Util.newHashMapOfValues(
							new Value<>(WorldType.DOMINION, SubspeciesSpawnRarity.FOUR_COMMON),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), null) {  //TODO move to fields
		@Override
		public void applySpeciesChanges(Body body) {
			if(body.getEar().getType()==EarType.RABBIT_MORPH) {
				body.getEar().setType(null, EarType.RABBIT_MORPH_FLOPPY);
			}
		}
		@Override
		public String[] getHalfDemonName(GameCharacter character) {
			String[] names = new String[] {
					"jackalope",
					"jackalopes",
					"jackalope",
					"jackalope",
					"jackalopes",
					"jackalopes"};
			
			if(character!=null && !character.getHalfDemonSubspecies().isNonBiped()) {
				names = new String[] {
					applyNonBipedNameChange(character, "jackalope", false, false),
					applyNonBipedNameChange(character, "jackalope", false, true),
					applyNonBipedNameChange(character, "jackalope", false, false),
					applyNonBipedNameChange(character, "jackalope", true, false),
					applyNonBipedNameChange(character, "jackalope", false, true),
					applyNonBipedNameChange(character, "jackalope", true, true)
				};
			}
			
			return names;
		}
	},
	
	BAT_MORPH(true,
			"statusEffects/race/raceBatMorph",
			"statusEffects/race/raceBackground",
			"bat-morph",
			"bat-morphs",
			"bat-boy",
			"bat-girl",
			"bat-boys",
			"bat-girls",
			"bat",
			"Due to their unique echolocation ability, all bat-morphs have a natural desire to talk as much as possible."
					+ " Due to this, [npc.name] continuously [npc.verb(play)] out conversations in [npc.her] head, allowing [npc.herHim] to think up new and exciting ways to seduce people before having ever met them.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 5f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 0f),
					new Value<Attribute, Float>(Attribute.DAMAGE_LUST, 15f)),
			null,
			"Flying Foxes",
			"Flying Foxes'",
			"BAT_MORPH_BASIC",
			"BAT_MORPH_ADVANCED",
			Race.BAT_MORPH,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 2),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_BAT_MORPH,
			SubspeciesPreference.FOUR_ABUNDANT,
			"An anthropomorphic, bipedal bat.", Util.newHashMapOfValues(
							new Value<>(WorldType.SUBMISSION, SubspeciesSpawnRarity.ONE_VERY_RARE),
							new Value<>(WorldType.BAT_CAVERNS, SubspeciesSpawnRarity.FOUR_COMMON),
							new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.ZERO_EXTREMELY_RARE)), null),
	
	// AVIAN:
	HARPY(true,
			"statusEffects/race/raceHarpy",
			"statusEffects/race/raceBackground",
			"harpy",
			"harpies",
			"harpy",
			"harpy",
			"harpies",
			"harpies",
			"bird",
			"[npc.NameIsFull] obsessed with [npc.her] appearance, and wouldn't think it unusual for someone to want to spend at least half of their waking hours preening themselves in order to look as attractive as possible.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 5f),
					new Value<Attribute, Float>(Attribute.DAMAGE_LUST, 15f)),
			null,
			"All About Harpies",
			"All About Harpies'",
			"HARPY_BASIC",
			"HARPY_ADVANCED",
			Race.HARPY,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.RACE_HARPY,
			SubspeciesPreference.FOUR_ABUNDANT,
			"An anthropomorphic, bipedal bird. Typically only possessing non-human arms, legs, eyes, ears, and hair.",
			Util.newHashMapOfValues(
					new Value<>(WorldType.HARPY_NEST, SubspeciesSpawnRarity.FOUR_COMMON),
					new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), Util.newArrayListOfValues(
					SubspeciesFlag.DISBALE_SPAWN_PREFERENCE,
					SubspeciesFlag.DISBALE_FURRY_PREFERENCE)) {
		@Override
		public String[] getHalfDemonName(GameCharacter character) {
			String[] names = new String[] {
					"fury",
					"furies",
					"fury",
					"fury",
					"furies",
					"furies"};
			
			if(character!=null && !character.getHalfDemonSubspecies().isNonBiped()) {
				names = new String[] {
					applyNonBipedNameChange(character, "fury", false, false),
					applyNonBipedNameChange(character, "fury", false, true),
					applyNonBipedNameChange(character, "fury", false, false),
					applyNonBipedNameChange(character, "fury", true, false),
					applyNonBipedNameChange(character, "fury", false, true),
					applyNonBipedNameChange(character, "fury", true, true)
				};
			}
			
			return names;
		}
	},
	
	HARPY_RAVEN(false,
			"statusEffects/race/raceHarpy",
			"statusEffects/race/raceBackground",
			"raven-harpy",
			"raven-harpies",
			"raven-harpy",
			"raven-harpy",
			"raven-harpies",
			"raven-harpies",
			"raven",
			"[npc.NameIsFull] obsessed with [npc.her] appearance, and wouldn't think it unusual for someone to want to spend at least half of their waking hours preening themselves in order to look as attractive as possible.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 5f),
					new Value<Attribute, Float>(Attribute.DAMAGE_LUST, 15f)),
			null,
			"All About Harpies",
			"All About Harpies'",
			"HARPY_BASIC",
			"HARPY_ADVANCED",
			Race.HARPY,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.BASE_BLACK,
			SubspeciesPreference.ONE_LOW,
			"An anthropomorphic, bipedal raven, with dark black feathers. Typically only possessing non-human arms, legs, eyes, ears, and hair.",
			Util.newHashMapOfValues(
					new Value<>(WorldType.HARPY_NEST, SubspeciesSpawnRarity.TWO_RARE),
					new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), Util.newArrayListOfValues(
					SubspeciesFlag.DISBALE_FURRY_PREFERENCE)) {
		@Override
		public void applySpeciesChanges(Body body) {
			if(Math.random()<0.5f) {
				body.getCoverings().put(BodyCoveringType.FEATHERS, new Covering(BodyCoveringType.FEATHERS, CoveringPattern.NONE, PresetColour.COVERING_BLACK, false, PresetColour.COVERING_BLACK, false));
				body.getCoverings().put(BodyCoveringType.BODY_HAIR_HARPY, new Covering(BodyCoveringType.BODY_HAIR_HARPY, CoveringPattern.NONE, PresetColour.COVERING_BLACK, false, PresetColour.COVERING_BLACK, false));
			} else {
				body.getCoverings().put(BodyCoveringType.FEATHERS, new Covering(BodyCoveringType.FEATHERS, CoveringPattern.NONE, PresetColour.COVERING_JET_BLACK, false, PresetColour.COVERING_JET_BLACK, false));
				body.getCoverings().put(BodyCoveringType.BODY_HAIR_HARPY, new Covering(BodyCoveringType.BODY_HAIR_HARPY, CoveringPattern.NONE, PresetColour.COVERING_JET_BLACK, false, PresetColour.COVERING_JET_BLACK, false));
			}
		}
		@Override
		public String[] getHalfDemonName(GameCharacter character) {
			String[] names = new String[] {
					"fury",
					"furies",
					"fury",
					"fury",
					"furies",
					"furies"};
			
			if(character!=null && !character.getHalfDemonSubspecies().isNonBiped()) {
				names = new String[] {
					applyNonBipedNameChange(character, "fury", false, false),
					applyNonBipedNameChange(character, "fury", false, true),
					applyNonBipedNameChange(character, "fury", false, false),
					applyNonBipedNameChange(character, "fury", true, false),
					applyNonBipedNameChange(character, "fury", false, true),
					applyNonBipedNameChange(character, "fury", true, true)
				};
			}
			
			return names;
		}
	},

	HARPY_BALD_EAGLE(false,
			"statusEffects/race/raceHarpy",
			"statusEffects/race/raceBackground",
			"bald-eagle-harpy",
			"bald-eagle-harpies",
			"bald-eagle-harpy",
			"bald-eagle-harpy",
			"bald-eagle-harpies",
			"bald-eagle-harpies",
			"bald-eagle",
			"[npc.NameIsFull] obsessed with [npc.her] appearance, and wouldn't think it unusual for someone to want to spend at least half of their waking hours preening themselves in order to look as attractive as possible.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 5f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 0f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 5f),
					new Value<Attribute, Float>(Attribute.DAMAGE_LUST, 15f)),
			null,
			"All About Harpies",
			"All About Harpies'",
			"HARPY_BASIC",
			"HARPY_ADVANCED",
			Race.HARPY,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 2),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 0)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 2),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 0)),
			PresetColour.BASE_WHITE,
			SubspeciesPreference.ONE_LOW,
			"An anthropomorphic, bipedal bald eagle, dark brown feathers covering their body and white feathers on their head. Typically only possessing non-human arms, legs, eyes, ears, and hair.",
			Util.newHashMapOfValues(
					new Value<>(WorldType.HARPY_NEST, SubspeciesSpawnRarity.ONE_VERY_RARE),
					new Value<>(WorldType.NIGHTLIFE_CLUB, SubspeciesSpawnRarity.FOUR_COMMON)), Util.newArrayListOfValues(
					SubspeciesFlag.DISBALE_FURRY_PREFERENCE)) {
		@Override
		public void applySpeciesChanges(Body body) {
			body.getCoverings().put(BodyCoveringType.FEATHERS, new Covering(BodyCoveringType.FEATHERS, CoveringPattern.NONE, PresetColour.COVERING_BROWN_DARK, false, PresetColour.COVERING_BROWN_DARK, false));
			body.getCoverings().put(BodyCoveringType.HAIR_HARPY, new Covering(BodyCoveringType.HAIR_HARPY, CoveringPattern.NONE, PresetColour.COVERING_WHITE, false, PresetColour.COVERING_WHITE, false));
			body.getCoverings().put(BodyCoveringType.BODY_HAIR_HARPY, new Covering(BodyCoveringType.BODY_HAIR_HARPY, CoveringPattern.NONE, PresetColour.COVERING_BROWN_DARK, false, PresetColour.COVERING_BROWN_DARK, false));
		}
		@Override
		public String[] getHalfDemonName(GameCharacter character) {
			String[] names = new String[] {
					"fury",
					"furies",
					"fury",
					"fury",
					"furies",
					"furies"};
			
			if(character!=null && !character.getHalfDemonSubspecies().isNonBiped()) {
				names = new String[] {
					applyNonBipedNameChange(character, "fury", false, false),
					applyNonBipedNameChange(character, "fury", false, true),
					applyNonBipedNameChange(character, "fury", false, false),
					applyNonBipedNameChange(character, "fury", true, false),
					applyNonBipedNameChange(character, "fury", false, true),
					applyNonBipedNameChange(character, "fury", true, true)
				};
			}
			
			return names;
		}
	},

	HARPY_PHOENIX(false,
			"statusEffects/race/raceHarpy",
			"statusEffects/race/raceBackgroundPhoenix",
			"phoenix-harpy",
			"phoenix-harpies",
			"phoenix-harpy",
			"phoenix-harpy",
			"phoenix-harpies",
			"phoenix-harpies",
			"phoenix",
			"While just as obsessed with [npc.her] looks as other harpies, [npc.name] is also naturally talented at harnessing the arcane, allowing [npc.herHim] to learn and cast spells with relative ease."
				+ " In particular, [npc.she] [npc.has] an exceptionally high affinity with arcane fire...",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 5f),
					new Value<Attribute, Float>(Attribute.MAJOR_ARCANE, 10f),
					new Value<Attribute, Float>(Attribute.MAJOR_CORRUPTION, 10f),
					new Value<Attribute, Float>(Attribute.DAMAGE_FIRE, 75f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_FIRE, 5f),
					new Value<Attribute, Float>(Attribute.DAMAGE_LUST, 15f)),
			null,
			"All About Harpies",
			"All About Harpies'",
			"HARPY_BASIC",
			"HARPY_ADVANCED",
			Race.HARPY,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 3),
					new Value<>(PerkCategory.ARCANE, 5)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 1),
					new Value<>(PerkCategory.LUST, 3),
					new Value<>(PerkCategory.ARCANE, 5)),
			PresetColour.BASE_ORANGE,
			SubspeciesPreference.ONE_LOW,
			"An anthropomorphic, bipedal, mythological bird, whose feathers are either glowing red, orange, or yellow, or are actually made out of arcane fire. They are extremely rare and typically only possess non-human arms, legs, eyes, ears, and hair.",
			Util.newHashMapOfValues(
					new Value<>(WorldType.HARPY_NEST, SubspeciesSpawnRarity.ZERO_EXTREMELY_RARE)), Util.newArrayListOfValues(
					SubspeciesFlag.DISBALE_FURRY_PREFERENCE)) {
		@Override
		public void applySpeciesChanges(Body body) {
			CoveringPattern pattern = CoveringPattern.OMBRE;
			if(Math.random()<0.5f) {
				pattern = CoveringPattern.HIGHLIGHTS;
			}
			body.getCoverings().put(BodyCoveringType.FEATHERS, new Covering(BodyCoveringType.FEATHERS, pattern, PresetColour.COVERING_ORANGE, true, PresetColour.COVERING_YELLOW, true));
			body.getCoverings().put(BodyCoveringType.HAIR_HARPY, new Covering(BodyCoveringType.HAIR_HARPY, pattern, PresetColour.COVERING_RED, true, PresetColour.COVERING_ORANGE, true));
			body.getCoverings().put(BodyCoveringType.BODY_HAIR_HARPY, new Covering(BodyCoveringType.BODY_HAIR_HARPY, CoveringPattern.NONE, PresetColour.COVERING_RED, true, PresetColour.COVERING_RED, true));
		}
		@Override
		public String[] getHalfDemonName(GameCharacter character) {
			String[] names = new String[] {
					"phoenix-fury",
					"phoenix-furies",
					"phoenix-fury",
					"phoenix-fury",
					"phoenix-furies",
					"phoenix-furies"};
			
			if(character!=null && !character.getHalfDemonSubspecies().isNonBiped()) {
				names = new String[] {
					applyNonBipedNameChange(character, "phoenix-fury", false, false),
					applyNonBipedNameChange(character, "phoenix-fury", false, true),
					applyNonBipedNameChange(character, "phoenix-fury", false, false),
					applyNonBipedNameChange(character, "phoenix-fury", true, false),
					applyNonBipedNameChange(character, "phoenix-fury", false, true),
					applyNonBipedNameChange(character, "phoenix-fury", true, true)
				};
			}
			
			return names;
		}
	},
	
	// ELEMENTALS:


	ELEMENTAL_FIRE(false,
			"statusEffects/race/raceElemental",
			"statusEffects/race/raceBackgroundFire",
			"fire elemental",
			"fire elementals",
			"fire elemental",
			"fire elemental",
			"fire elementals",
			"fire elementals",
			"fire",
			"[npc.NameIsFull] a summoned elemental, currently bound to the school of Fire.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 15f),
					new Value<Attribute, Float>(Attribute.DAMAGE_FIRE, 50f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_FIRE, 50f)),
			Util.newArrayListOfValues(
					"[style.boldExcellent(Unlimited)] <b style='color: "+ PresetColour.TRANSFORMATION_GENERIC.toWebHexString()+ ";'> self-transformations</b>"),
			"Fire Elementals",
			"Fire Elementals'",
			"ELEMENTAL_FIRE_BASIC",
			"ELEMENTAL_FIRE_ADVANCED",
			Race.ELEMENTAL,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 5)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 5)),
			PresetColour.SPELL_SCHOOL_FIRE,
			SubspeciesPreference.FOUR_ABUNDANT,
			"An arcane elemental bound to the school of Fire.",
			Util.newHashMapOfValues(), Util.newArrayListOfValues(
					SubspeciesFlag.HIDDEN_FROM_PREFERENCES)) {
		@Override
		public void applySpeciesChanges(Body body) {
			body.setBodyMaterial(BodyMaterial.FIRE);
		}
		@Override
		public String getSVGString(GameCharacter character) {
			if(character!=null && !((Elemental)character).getSummoner().isElementalActive()) {
				if(((Elemental)character).getPassiveForm()==null) {
					String wispSVG = SvgUtil.colourReplacement(this.toString(),
									this.getColour(character),
									this.getColour(character),
									this.getColour(character),
									"<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getRaceWisp()+"</div>");
					return wispSVG;
				}
				String raceSvg = SvgUtil.colourReplacement(this.toString(),
						this.getColour(character),
						this.getColour(character),
						this.getColour(character),
						((Elemental)character).getPassiveForm().SVGStringUncoloured);
				return getBipedBackground(raceSvg, character, this.getColour(character));
			}
			return super.getSVGString(character);
		}
	},
	
	ELEMENTAL_EARTH(false,
			"statusEffects/race/raceElemental",
			"statusEffects/race/raceBackgroundEarth",
			"earth elemental",
			"earth elementals",
			"earth elemental",
			"earth elemental",
			"earth elementals",
			"earth elementals",
			"earth",
			"[npc.NameIsFull] a summoned elemental, currently bound to the school of Earth.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 50f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 50f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_PHYSICAL, 50f)),
			Util.newArrayListOfValues(
					"[style.boldExcellent(Unlimited)] <b style='color: "+ PresetColour.TRANSFORMATION_GENERIC.toWebHexString()+ ";'> self-transformations</b>"),
			"Earth Elementals",
			"Earth Elementals'",
			"ELEMENTAL_EARTH_BASIC",
			"ELEMENTAL_EARTH_ADVANCED",
			Race.ELEMENTAL,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 5)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 1),
					new Value<>(PerkCategory.ARCANE, 5)),
			PresetColour.SPELL_SCHOOL_EARTH,
			SubspeciesPreference.FOUR_ABUNDANT,
			"An arcane elemental bound to the school of Earth.",
			Util.newHashMapOfValues(), Util.newArrayListOfValues(
					SubspeciesFlag.HIDDEN_FROM_PREFERENCES)) {
		@Override
		public void applySpeciesChanges(Body body) {
			body.setBodyMaterial(BodyMaterial.STONE);
		}
		@Override
		public String getSVGString(GameCharacter character) {
			if(character!=null && !((Elemental)character).getSummoner().isElementalActive()) {
				if(((Elemental)character).getPassiveForm()==null) {
					String wispSVG = SvgUtil.colourReplacement(this.toString(),
							this.getColour(character),
							this.getColour(character),
							this.getColour(character),
							"<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getRaceWisp()+"</div>");
					return wispSVG;
				}
				String raceSvg = SvgUtil.colourReplacement(this.toString(),
						this.getColour(character),
						this.getColour(character),
						this.getColour(character),
						((Elemental)character).getPassiveForm().SVGStringUncoloured);
				return getBipedBackground(raceSvg, character, this.getColour(character));
			}
			return super.getSVGString(character);
		}
	},

	ELEMENTAL_WATER(false,
			"statusEffects/race/raceElemental",
			"statusEffects/race/raceBackgroundWater",
			"water elemental",
			"water elementals",
			"water elemental",
			"water elemental",
			"water elementals",
			"water elementals",
			"water",
			"[npc.NameIsFull] a summoned elemental, currently bound to the school of Water.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 15f),
					new Value<Attribute, Float>(Attribute.DAMAGE_ICE, 50f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_ICE, 50f)),
			Util.newArrayListOfValues(
					"[style.boldExcellent(Unlimited)] <b style='color: "+ PresetColour.TRANSFORMATION_GENERIC.toWebHexString()+ ";'> self-transformations</b>"),
			"Water Elementals",
			"Water Elementals'",
			"ELEMENTAL_WATER_BASIC",
			"ELEMENTAL_WATER_ADVANCED",
			Race.ELEMENTAL,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 3),
					new Value<>(PerkCategory.ARCANE, 5)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 3),
					new Value<>(PerkCategory.ARCANE, 5)),
			PresetColour.SPELL_SCHOOL_WATER,
			SubspeciesPreference.FOUR_ABUNDANT,
			"An arcane elemental bound to the school of Water.",
			Util.newHashMapOfValues(), Util.newArrayListOfValues(
					SubspeciesFlag.HIDDEN_FROM_PREFERENCES)) {
		@Override
		public void applySpeciesChanges(Body body) {
			body.setBodyMaterial(BodyMaterial.WATER);
		}
		@Override
		public String getSVGString(GameCharacter character) {
			if(character!=null && !((Elemental)character).getSummoner().isElementalActive()) {
				if(((Elemental)character).getPassiveForm()==null) {
					String wispSVG = SvgUtil.colourReplacement(this.toString(),
									this.getColour(character),
									this.getColour(character),
									this.getColour(character),
									"<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getRaceWisp()+"</div>");
					return wispSVG;
				}
				String raceSvg = SvgUtil.colourReplacement(this.toString(),
						this.getColour(character),
						this.getColour(character),
						this.getColour(character),
						((Elemental)character).getPassiveForm().SVGStringUncoloured);
				return getBipedBackground(raceSvg, character, this.getColour(character));
			}
			return super.getSVGString(character);
		}
	},

	ELEMENTAL_AIR(false,
			"statusEffects/race/raceElemental",
			"statusEffects/race/raceBackgroundAir",
			"air elemental",
			"air elementals",
			"air elemental",
			"air elemental",
			"air elementals",
			"air elementals",
			"air",
			"[npc.NameIsFull] a summoned elemental, currently bound to the school of Air.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 5f),
					new Value<Attribute, Float>(Attribute.DAMAGE_POISON, 50f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_POISON, 50f)),
			Util.newArrayListOfValues(
					"[style.boldExcellent(Unlimited)] <b style='color: "+ PresetColour.TRANSFORMATION_GENERIC.toWebHexString()+ ";'> self-transformations</b>"),
			"Air Elementals",
			"Air Elementals'",
			"ELEMENTAL_AIR_BASIC",
			"ELEMENTAL_AIR_ADVANCED",
			Race.ELEMENTAL,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 5)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 5)),
			PresetColour.SPELL_SCHOOL_AIR,
			SubspeciesPreference.FOUR_ABUNDANT,
			"An arcane elemental bound to the school of Air.",
			Util.newHashMapOfValues(), Util.newArrayListOfValues(
					SubspeciesFlag.HIDDEN_FROM_PREFERENCES)) {
		@Override
		public void applySpeciesChanges(Body body) {
			body.setBodyMaterial(BodyMaterial.AIR);
		}
		@Override
		public String getSVGString(GameCharacter character) {
			if(character!=null && !((Elemental)character).getSummoner().isElementalActive()) {
				if(((Elemental)character).getPassiveForm()==null) {
					String wispSVG = SvgUtil.colourReplacement(this.toString(),
									this.getColour(character),
									this.getColour(character),
									this.getColour(character),
									"<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getRaceWisp()+"</div>");
					return wispSVG;
				}
				String raceSvg = SvgUtil.colourReplacement(this.toString(),
						this.getColour(character),
						this.getColour(character),
						this.getColour(character),
						((Elemental)character).getPassiveForm().SVGStringUncoloured);
				return getBipedBackground(raceSvg, character, this.getColour(character));
			}
			return super.getSVGString(character);
		}
	},

	ELEMENTAL_ARCANE(true,
			"statusEffects/race/raceElemental",
			"statusEffects/race/raceBackgroundArcane",
			"arcane elemental",
			"arcane elementals",
			"arcane elemental",
			"arcane elemental",
			"arcane elementals",
			"arcane elementals",
			"arcane",
			"[npc.NameIsFull] a summoned elemental, currently bound to the school of Arcane.",
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.MAJOR_PHYSIQUE, 15f),
					new Value<Attribute, Float>(Attribute.DAMAGE_LUST, 50f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_LUST, 50f)),
			Util.newArrayListOfValues(
					"[style.boldExcellent(Unlimited)] <b style='color: "+ PresetColour.TRANSFORMATION_GENERIC.toWebHexString()+ ";'> self-transformations</b>"),
			"Arcane Elementals",
			"Arcane Elementals'",
			"ELEMENTAL_ARCANE_BASIC",
			"ELEMENTAL_ARCANE_ADVANCED",
			Race.ELEMENTAL,
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 5)),
			Util.newHashMapOfValues(
					new Value<>(PerkCategory.PHYSICAL, 5),
					new Value<>(PerkCategory.LUST, 5),
					new Value<>(PerkCategory.ARCANE, 5)),
			PresetColour.SPELL_SCHOOL_ARCANE,
			SubspeciesPreference.FOUR_ABUNDANT,
			"An arcane elemental bound to the school of Arcane.",
			Util.newHashMapOfValues(), Util.newArrayListOfValues(
					SubspeciesFlag.HIDDEN_FROM_PREFERENCES)) {
		@Override
		public void applySpeciesChanges(Body body) {
			body.setBodyMaterial(BodyMaterial.ARCANE);
		}
		@Override
		public String getSVGString(GameCharacter character) {
			if(character!=null && !((Elemental)character).getSummoner().isElementalActive()) {
				if(((Elemental)character).getPassiveForm()==null) {
					String wispSVG = SvgUtil.colourReplacement(this.toString(),
									this.getColour(character),
									this.getColour(character),
									this.getColour(character),
									"<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getRaceWisp()+"</div>");
					return wispSVG;
				}
				String raceSvg = SvgUtil.colourReplacement(this.toString(),
						this.getColour(character),
						this.getColour(character),
						this.getColour(character),
						((Elemental)character).getPassiveForm().SVGStringUncoloured);
				return getBipedBackground(raceSvg, character, this.getColour(character));
			}
			return super.getSVGString(character);
		}
	},
	
	;
	//TENGU(Race.TENGU.getName(), Race.TENGU, RacialBody.TENGU, SubspeciesPreference.TWO_LOW,
	//		"A hermetic kind of "+Race.HARPY.getName());

	private boolean mainSubspecies;
	private String name;
	private String namePlural;
	private String singularMaleName;
	private String singularFemaleName;
	private String pluralMaleName;
	private String pluralFemaleName;
	private String feralName;
	
	private String statusEffectDescription;
	private Map<PerkCategory, Integer> perkWeightingFeminine;
	private Map<PerkCategory, Integer> perkWeightingMasculine;
	private Map<Attribute, Float> statusEffectAttributeModifiers;
	private List<String> extraEffects;

	private String bookName;
	private String bookNamePlural;
	private String basicDescriptionId;
	private String advancedDescriptionId;
	
	private AbstractRace race;
	private Colour colour;
	private SubspeciesPreference subspeciesPreferenceDefault;
	private String description;
	
	protected String SVGString;
	protected String SVGStringUncoloured;
	protected String SVGStringNoBackground;
	protected String SVGStringDesaturated;
	protected String slimeSVGString;
	protected String halfDemonSVGString;
	protected String demonSVGString;
	
	private Map<AbstractWorldType, SubspeciesSpawnRarity> worldLocations;
	
	private List<SubspeciesFlag> flags;

	private static Map<Integer, String> youkoIconMap;
	private static Map<Integer, String> youkoDesaturatedIconMap;
	private static Map<Integer, String> youkoHalfDemonIconMap;
	
	private static Map<AbstractWorldType, Map<Subspecies, SubspeciesSpawnRarity>> worldSpecies;
	private static Map<Subspecies, SubspeciesSpawnRarity> dominionStormImmuneSpecies;
	private static Map<AbstractRace, List<Subspecies>> subspeciesFromRace;
	
	static {
		youkoIconMap = new HashMap<>();
		youkoHalfDemonIconMap = new HashMap<>();
		for(int i=1; i<=9; i++) {
			try {
				String SVGStringBackground = "";
				InputStream is = Subspecies.class.getClassLoader().getResourceAsStream("com/lilithsthrone/res/statusEffects/race/raceBackground.svg");
				if(is==null) {
					System.err.println("Error! Subspecies background icon file does not exist (Trying to read from 'statusEffects/race/raceBackground')! (Code 1f)");
				}
				SVGStringBackground = "<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+Util.inputStreamToString(is)+"</div>";

				is.close();
				
				String baseSVGString = SVGStringBackground + "<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getFoxTail(i)+"</div>";
				youkoIconMap.put(i, baseSVGString);

				baseSVGString = SvgUtil.colourReplacement("youkohalfDemon"+i,
							PresetColour.RACE_HALF_DEMON,
							PresetColour.RACE_HALF_DEMON,
							PresetColour.RACE_HALF_DEMON,
							"<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>" + SVGImages.SVG_IMAGE_PROVIDER.getRaceBackgroundDemon()+"</div>"
								+ "<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getFoxTailDemon(i)+"</div>");
				youkoHalfDemonIconMap.put(i, baseSVGString);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		youkoDesaturatedIconMap = new HashMap<>();
		for(int i=1; i<=9; i++) {
			try {
				String SVGStringBackground = "";
				InputStream is = Subspecies.class.getClassLoader().getResourceAsStream("com/lilithsthrone/res/statusEffects/race/raceBackground.svg");
				if(is==null) {
					System.err.println("Error! Subspecies background icon file does not exist (Trying to read from 'statusEffects/race/raceBackground')! (Code 2f)");
				}
				SVGStringBackground = "<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+Util.inputStreamToString(is)+"</div>";
				
				is.close();
				
				String baseSVGString = SVGStringBackground + "<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getFoxTailDesaturated(i)+"</div>";
				
				baseSVGString = SvgUtil.colourReplacement("youkoGradient"+i,
						PresetColour.BASE_GREY,
						PresetColour.BASE_GREY,
						PresetColour.BASE_GREY,
						baseSVGString);
				
				youkoDesaturatedIconMap.put(i, baseSVGString);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		worldSpecies = new HashMap<>();
		dominionStormImmuneSpecies = new HashMap<>();
		subspeciesFromRace = new HashMap<>();
		
		for(Subspecies species : Subspecies.values()) {
			subspeciesFromRace.putIfAbsent(species.getRace(), new ArrayList<>());
			subspeciesFromRace.get(species.getRace()).add(species);
			for(Entry<AbstractWorldType, SubspeciesSpawnRarity> type : species.getWorldLocations().entrySet()) {
				worldSpecies.putIfAbsent(type.getKey(), new HashMap<>());
				worldSpecies.get(type.getKey()).put(species, type.getValue());
				
				try {
					if(type.getKey()==WorldType.DOMINION && species.getRace()==Race.DEMON && species.getStatusEffectAttributeModifiers(null).get(Attribute.MAJOR_ARCANE)>=IntelligenceLevel.TWO_SMART.getMinimumValue()) {
						dominionStormImmuneSpecies.put(species, type.getValue());
					}
				} catch(Exception ex) {	
				}
			}
		}
		
		for(List<Subspecies> e : subspeciesFromRace.values()) {
			e.sort((s1, s2) -> s1.getName(null).compareTo(s2.getName(null)));
		}
	}
	
	private Subspecies(
			boolean mainSubspecies,
			String iconPathName,
			String iconBackgroundPathName,
			String name,
			String namePlural,
			String singularMaleName,
			String singularFemaleName,
			String pluralMaleName,
			String pluralFemaleName,
			String feralName,
			String statusEffectDescription,
			Map<Attribute, Float> statusEffectAttributeModifiers,
			List<String> extraEffects,
			String bookName,
			String bookNamePlural,
			String basicDescription,
			String advancedDescription,
			AbstractRace race,
			Map<PerkCategory, Integer> perkWeightingFeminine,
			Map<PerkCategory, Integer> perkWeightingMasculine,
			Colour colour,
			SubspeciesPreference subspeciesPreferenceDefault,
			String description,
			Map<AbstractWorldType, SubspeciesSpawnRarity> worldLocations, List<SubspeciesFlag> flags) {
		
		this.mainSubspecies = mainSubspecies;
		this.name = name;
		this.namePlural = namePlural;

		this.singularMaleName = singularMaleName;
		this.singularFemaleName = singularFemaleName;
		
		this.pluralMaleName = pluralMaleName;
		this.pluralFemaleName = pluralFemaleName;
		
		this.feralName = feralName;

		this.statusEffectDescription = statusEffectDescription;
		
		this.statusEffectAttributeModifiers = statusEffectAttributeModifiers;
		if(this.statusEffectAttributeModifiers!=null) {
			this.statusEffectAttributeModifiers.entrySet().removeIf((entry) -> entry.getValue()==0);
		}
		
		if(perkWeightingFeminine!=null) {
			this.perkWeightingFeminine = perkWeightingFeminine;
		} else {
			this.perkWeightingFeminine = new HashMap<>();
		}
		if(perkWeightingMasculine!=null) {
			this.perkWeightingMasculine = perkWeightingMasculine;
		} else {
			this.perkWeightingMasculine = new HashMap<>();
		}

		if(extraEffects == null) {
			this.extraEffects = new ArrayList<>();
		} else {
			this.extraEffects = extraEffects;
		}
		
		this.bookName = bookName;
		this.bookNamePlural = bookNamePlural;
		
		this.basicDescriptionId = basicDescription;
		this.advancedDescriptionId = advancedDescription;
		
		this.race = race;
		this.colour = colour;
		this.subspeciesPreferenceDefault = subspeciesPreferenceDefault;
		this.description = description;

		if(worldLocations == null) {
			this.worldLocations = new HashMap<>();
		} else {
			this.worldLocations = worldLocations;
		}
		
		if(flags == null) {
			this.flags = new ArrayList<>();
		} else {
			this.flags = flags;
		}
		
		if(iconPathName!=null) {
			try {
				InputStream is = this.getClass().getResourceAsStream("/com/lilithsthrone/res/" + iconPathName + ".svg");
				if(is==null) {
					System.err.println("Error! Subspecies icon file does not exist (Trying to read from '"+iconPathName+"')! (Code 1)");
				}
				SVGStringUncoloured = Util.inputStreamToString(is);
				
				is.close();
				
				String SVGStringBackground = "";
				if(!iconBackgroundPathName.isEmpty()) {
					is = this.getClass().getResourceAsStream("/com/lilithsthrone/res/" + iconBackgroundPathName + ".svg");
					if(is==null) {
						System.err.println("Error! Subspecies background icon file does not exist (Trying to read from '"+iconPathName+"')! (Code 1)");
					}
					SVGStringBackground = "<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+Util.inputStreamToString(is)+"</div>";
					
					is.close();
				}
				

				SVGStringNoBackground = SvgUtil.colourReplacement(this.toString(),
						colour,
						colour,
						colour,
						"<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGStringUncoloured+"</div>");
				
				SVGStringUncoloured = SVGStringBackground + "<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGStringUncoloured+"</div>";
				
				slimeSVGString = SvgUtil.colourReplacement(this.toString(),
						PresetColour.RACE_SLIME,
						PresetColour.RACE_SLIME,
						PresetColour.RACE_SLIME,
						"<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>" + SVGImages.SVG_IMAGE_PROVIDER.getRaceBackgroundSlime()+"</div>"
						+ "<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGStringUncoloured+"</div>");

				halfDemonSVGString = SvgUtil.colourReplacement(this.toString(),
						PresetColour.RACE_HALF_DEMON,
						PresetColour.RACE_HALF_DEMON,
						PresetColour.RACE_HALF_DEMON,
						"<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>" + SVGImages.SVG_IMAGE_PROVIDER.getRaceBackgroundDemon()+"</div>"
						+ "<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGStringUncoloured+"</div>");

				demonSVGString = SvgUtil.colourReplacement(this.toString(),
						PresetColour.RACE_DEMON,
						PresetColour.RACE_DEMON,
						PresetColour.RACE_DEMON,
						"<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>" + SVGImages.SVG_IMAGE_PROVIDER.getRaceBackgroundDemon()+"</div>"
						+ "<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGStringUncoloured+"</div>");
				
				SVGStringDesaturated = SvgUtil.colourReplacement(this.toString(),
						PresetColour.BASE_GREY,
						PresetColour.BASE_GREY,
						PresetColour.BASE_GREY,
						SVGStringUncoloured);
				
				SVGString = SvgUtil.colourReplacement(this.toString(),
						colour,
						colour,
						colour,
						SVGStringUncoloured);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			SVGString = "";
		}
	}
	
	/**
	 * Changes that should be applied to characters of this species upon generation. Called <b>after</b> this Subspecies' Race.applyRaceChanges().
	 */
	public void applySpeciesChanges(Body body) {
	}

	/**
	 * Changes that should be applied to any offspring of this species.
	 */
	public void applyOffspringSpeciesChanges(Body body) {
		applySpeciesChanges(body);
	}

	public static Subspecies getMainSubspeciesOfRace(AbstractRace race) {
		Subspecies backup = Subspecies.HUMAN;
		for(Subspecies sub : Subspecies.values()) {
			if(sub.getRace()==race) {
				if(sub.isMainSubspecies()) {
					return sub;
				}
				backup = sub;
			}
		}
		System.err.println("Warning: getMainSubspeciesOfRace("+Race.getIdFromRace(race)+") did not find a main subspecies!");
		return backup;
	}
	
	/**
	 * @return The race of this body if it were made from flesh. (i.e. The body's race ignoring slime/elemental modifiers.)
	 */
	public static Subspecies getFleshSubspecies(GameCharacter character) {
		return getSubspeciesFromBody(character, character.getBody(), character.getBody().getRaceFromPartWeighting());
	}

	public static Subspecies getSubspeciesFromBody(GameCharacter character, Body body, AbstractRace race) {
		return getSubspeciesFromBody(character, body, race, false);
	}
	
	//TODO Make an internal method to get weighting of subspecies, then run through all subspecies and return the one with the highest weighting
	public static Subspecies getSubspeciesFromBody(GameCharacter character, Body body, AbstractRace race, boolean ignoreOverride) {
		
		switch(body.getBodyMaterial()) {
			case FIRE:
				if((character==null || !character.isElemental()) && race==Race.HARPY) {
					return Subspecies.HARPY_PHOENIX;
				}
				return Subspecies.ELEMENTAL_FIRE;
			case ICE:
			case WATER:
				return Subspecies.ELEMENTAL_WATER;
			case RUBBER:
			case STONE:
				return Subspecies.ELEMENTAL_EARTH;
			case AIR:
				return Subspecies.ELEMENTAL_AIR;
			case ARCANE:
				return Subspecies.ELEMENTAL_ARCANE;
			case SLIME:
				if(race==Race.SLIME) {
					return Subspecies.SLIME;
				}
				break;
			case FLESH:
				break;
		}
		
//		Subspecies subOverride = body.getSubspeciesOverride();
//		
//		if(!ignoreOverride && subOverride!=null) {
//			if(subOverride==Subspecies.DEMON
//					|| subOverride==Subspecies.HALF_DEMON
//					|| subOverride==Subspecies.IMP
//					|| subOverride==Subspecies.IMP_ALPHA) {
//				if(body.getHeight()==Height.NEGATIVE_TWO_MIMIMUM) {
//					return Subspecies.IMP;
//				} else if(body.getHeight()==Height.NEGATIVE_ONE_TINY) {
//					return Subspecies.IMP_ALPHA;
//				}
//			}
//			
//			return subOverride;
//		}
		
		switch(body.getLeg().getLegConfiguration()) {
			case ARACHNID:
				break;
			case BIPEDAL:
				break;
			case CEPHALOPOD:
				break;
			case TAIL:
				break;
			case TAIL_LONG:
				break;
			case TAUR:
				if(body.getSubspeciesOverride()==null) {
					if(body.getLeg().getType().getRace()==Race.HORSE_MORPH) {
						if(body.getHorn().getType().equals(HornType.HORSE_STRAIGHT) && body.getHorn().getHornRows()==1 && body.getHorn().getHornsPerRow()==1) {
							if(body.getWing().getType()!=WingType.NONE) {
								return Subspecies.ALITAUR;
							}
							return Subspecies.UNITAUR;
						}
						if(body.getWing().getType()!=WingType.NONE) {
							return Subspecies.PEGATAUR;
						}
						if(body.getTail().getType()!=TailType.HORSE_MORPH_ZEBRA) {
							return Subspecies.CENTAUR;
						}
					}
				}
				break;
		}
		
		Subspecies subspecies = null;
		//TODO this needs to be replaced as soon as possible.
		if(race==Race.ALLIGATOR_MORPH) {
			subspecies = Subspecies.ALLIGATOR_MORPH;
		}
		if(race==Race.ANGEL) {
			subspecies = Subspecies.ANGEL;
		}
		if(race==Race.CAT_MORPH) {
			subspecies = Subspecies.CAT_MORPH;
			AbstractFaceType faceType = body.getFace().getType();
			BodyCoveringType felineFur = body.getBodyMaterial()==BodyMaterial.SLIME?BodyCoveringType.SLIME:BodyCoveringType.FELINE_FUR;
			
			if(body.getHair().getType() == HairType.CAT_MORPH_SIDEFLUFF
				&& body.getEar().getType()==EarType.CAT_MORPH_TUFTED
				&& body.getCoverings().get(felineFur).getModifier() == CoveringModifier.FLUFFY
				&& body.getTail().getType()==TailType.CAT_MORPH_SHORT) {
				subspecies = Subspecies.CAT_MORPH_LYNX;
					
			} else if((faceType == FaceType.CAT_MORPH_PANTHER || faceType == FaceType.HUMAN)
				&& body.getCoverings().get(felineFur).getPattern() == CoveringPattern.SPOTTED
				&& body.getCoverings().get(felineFur).getModifier() == CoveringModifier.FLUFFY
				&& body.getTail().getType()==TailType.CAT_MORPH) {
				subspecies = Subspecies.CAT_MORPH_LEOPARD_SNOW;
				
			} else if((faceType == FaceType.CAT_MORPH_PANTHER || faceType == FaceType.HUMAN)
				&& body.getCoverings().get(felineFur).getPattern() == CoveringPattern.SPOTTED
				&& body.getCoverings().get(felineFur).getModifier() == CoveringModifier.SHORT
				&& body.getTail().getType()==TailType.CAT_MORPH) {
				subspecies = Subspecies.CAT_MORPH_LEOPARD;
				
			} else if((faceType == FaceType.CAT_MORPH_PANTHER || faceType == FaceType.HUMAN)
				&& body.getCoverings().get(felineFur).getModifier() == CoveringModifier.SHORT
				&& body.getTail().getType()==TailType.CAT_MORPH_TUFTED) {
				subspecies = Subspecies.CAT_MORPH_LION;
				
			} else if((faceType == FaceType.CAT_MORPH_PANTHER || faceType == FaceType.HUMAN)
				&& body.getCoverings().get(felineFur).getPattern() == CoveringPattern.STRIPED
				&& body.getTail().getType()==TailType.CAT_MORPH) {
				subspecies = Subspecies.CAT_MORPH_TIGER;
				
			} else if((faceType == FaceType.CAT_MORPH || faceType == FaceType.HUMAN)
					&& body.getCoverings().get(felineFur).getPattern() == CoveringPattern.SPOTTED
					&& body.getCoverings().get(felineFur).getModifier() == CoveringModifier.SHORT
					&& body.getTail().getType()==TailType.CAT_MORPH) {
				subspecies = Subspecies.CAT_MORPH_CHEETAH;
				
			} else if(body.getEar().getType()==EarType.CAT_MORPH_TUFTED) {
				subspecies = Subspecies.CAT_MORPH_CARACAL;
			}
		}
			
		if(race==Race.COW_MORPH) {
			subspecies = Subspecies.COW_MORPH;
		}
		if(race==Race.DEMON) {
			subspecies = Subspecies.DEMON;
			if(body.getRaceWeightMap().size()>1) {
				subspecies = Subspecies.HALF_DEMON;
			} else if(body.getHeight()==Height.NEGATIVE_TWO_MIMIMUM) {
				subspecies = Subspecies.IMP;
			} else if(body.getHeight()==Height.NEGATIVE_ONE_TINY) {
				subspecies = Subspecies.IMP_ALPHA;
			}
		}
		if(race==Race.ELEMENTAL) {
			switch(body.getBodyMaterial()) {
				case AIR:
					subspecies = Subspecies.ELEMENTAL_AIR;
					break;
				case ARCANE:
					subspecies = Subspecies.ELEMENTAL_ARCANE;
					break;
				case FIRE:
					subspecies = Subspecies.ELEMENTAL_FIRE;
					break;
				case FLESH:
				case SLIME:
				case RUBBER:
				case STONE:
					subspecies = Subspecies.ELEMENTAL_EARTH;
					break;
				case ICE:
				case WATER:
					subspecies = Subspecies.ELEMENTAL_WATER;
					break;
			}
		}
		if(race==Race.DOG_MORPH) {
			subspecies = Subspecies.DOG_MORPH;
			BodyCoveringType canineFur = body.getBodyMaterial()==BodyMaterial.SLIME?BodyCoveringType.SLIME:BodyCoveringType.CANINE_FUR;
			
			if((body.getCoverings().get(canineFur).getPrimaryColour()==PresetColour.COVERING_BLACK
					|| body.getCoverings().get(canineFur).getPrimaryColour()==PresetColour.COVERING_JET_BLACK)
				&& (body.getCoverings().get(canineFur).getSecondaryColour()==PresetColour.COVERING_BROWN
						|| body.getCoverings().get(canineFur).getSecondaryColour()==PresetColour.COVERING_BROWN_DARK
						|| body.getCoverings().get(canineFur).getSecondaryColour()==PresetColour.COVERING_TAN)
				&& body.getCoverings().get(canineFur).getPattern() == CoveringPattern.MARKED
				&& body.getCoverings().get(canineFur).getModifier() == CoveringModifier.SHORT
				) {
				subspecies = Subspecies.DOG_MORPH_DOBERMANN;
			}
		
			if(body.getCoverings().get(canineFur).getPrimaryColour()==PresetColour.COVERING_BLACK
					&& body.getCoverings().get(canineFur).getSecondaryColour()==PresetColour.COVERING_WHITE
					&& body.getCoverings().get(canineFur).getPattern() == CoveringPattern.MARKED
					&& body.getCoverings().get(canineFur).getModifier() == CoveringModifier.FLUFFY
					&& (body.getEar().getType()==EarType.DOG_MORPH_FOLDED || body.getEar().getType()==EarType.DOG_MORPH_POINTED)
					) {
					subspecies = Subspecies.DOG_MORPH_BORDER_COLLIE;
			}
		
			if(body.getCoverings().get(canineFur).getPrimaryColour()==PresetColour.COVERING_BLACK
					&& body.getCoverings().get(canineFur).getSecondaryColour()==PresetColour.COVERING_TAN
					&& body.getCoverings().get(canineFur).getPattern() == CoveringPattern.MARKED
					&& body.getCoverings().get(canineFur).getModifier() == CoveringModifier.FLUFFY
					&& body.getEar().getType()==EarType.DOG_MORPH_POINTED
					) {
					subspecies = Subspecies.DOG_MORPH_GERMAN_SHEPHERD;
			}
			
		}
		if(race==Race.HARPY) {
			subspecies = Subspecies.HARPY;
			BodyCoveringType feathers = body.getBodyMaterial()==BodyMaterial.SLIME?BodyCoveringType.SLIME:BodyCoveringType.FEATHERS;
			BodyCoveringType headFeathers = body.getBodyMaterial()==BodyMaterial.SLIME?BodyCoveringType.SLIME_HAIR:BodyCoveringType.HAIR_HARPY;
			
			if(body.getCoverings().get(feathers).getPrimaryColour()==PresetColour.COVERING_BLACK
					|| body.getCoverings().get(feathers).getPrimaryColour()==PresetColour.COVERING_JET_BLACK) {
				subspecies = Subspecies.HARPY_RAVEN;
			}
			if(body.getCoverings().get(feathers).getPrimaryColour()==PresetColour.COVERING_BROWN_DARK
					&& body.getCoverings().get(headFeathers).getPrimaryColour()==PresetColour.COVERING_WHITE) {
				subspecies = Subspecies.HARPY_BALD_EAGLE;
			}
			if((body.getCoverings().get(feathers).getPrimaryColour()==PresetColour.COVERING_RED
					|| body.getCoverings().get(feathers).getPrimaryColour()==PresetColour.COVERING_ORANGE
					|| body.getCoverings().get(feathers).getPrimaryColour()==PresetColour.COVERING_YELLOW)
				&& body.getCoverings().get(feathers).isPrimaryGlowing()) {
				subspecies = Subspecies.HARPY_PHOENIX;
			}
		}
			
		if(race==Race.FOX_MORPH) {
			subspecies = Subspecies.FOX_MORPH;
			BodyCoveringType foxFur = body.getBodyMaterial()==BodyMaterial.SLIME?BodyCoveringType.SLIME:BodyCoveringType.FOX_FUR;
			Covering fox_fur = body.getCoverings().get(foxFur);
			List<Colour> fennecColours = Util.newArrayListOfValues(PresetColour.COVERING_DIRTY_BLONDE, PresetColour.COVERING_BLEACH_BLONDE, PresetColour.COVERING_TAN);
			
			if (fennecColours.contains(fox_fur.getPrimaryColour())
					&& (fennecColours.contains(fox_fur.getSecondaryColour()) || fox_fur.getPattern()==CoveringPattern.NONE)
					&& (body.getEar().getType()==EarType.FOX_MORPH_BIG)) {
				subspecies = body.getTail().getType() == TailType.FOX_MORPH_MAGIC
						?Subspecies.FOX_ASCENDANT_FENNEC
						:Subspecies.FOX_MORPH_FENNEC;
				
			} else if (fox_fur.getPrimaryColour() == PresetColour.COVERING_WHITE) {
				subspecies = body.getTail().getType() == TailType.FOX_MORPH_MAGIC
						?Subspecies.FOX_ASCENDANT_ARCTIC
						:Subspecies.FOX_MORPH_ARCTIC;
				
			} else if (body.getTail().getType() == TailType.FOX_MORPH_MAGIC) {
				subspecies = Subspecies.FOX_ASCENDANT;
				
			}
		}
			
		if(race==Race.HORSE_MORPH) {
			subspecies = Subspecies.HORSE_MORPH;
			
			if(body.getWing().getType()==WingType.FEATHERED) {
				if(body.getHorn().getType().equals(HornType.HORSE_STRAIGHT) && body.getHorn().getHornRows()==1 && body.getHorn().getHornsPerRow()==1) {
					return Subspecies.HORSE_MORPH_ALICORN;
				}
				return Subspecies.HORSE_MORPH_PEGASUS;
			}
			if(!body.getHorn().getType().equals(HornType.NONE) && body.getHorn().getHornRows()==1 && body.getHorn().getHornsPerRow()==1) {
				return Subspecies.HORSE_MORPH_UNICORN;
			}
			BodyCoveringType horseHair = body.getBodyMaterial()==BodyMaterial.SLIME?BodyCoveringType.SLIME:BodyCoveringType.HORSE_HAIR;
			Colour zebraPrimary = body.getCoverings().get(horseHair).getPrimaryColour();
			Colour zebraSecondary = body.getCoverings().get(horseHair).getSecondaryColour();
			if((((zebraPrimary==PresetColour.COVERING_BLACK || zebraPrimary==PresetColour.COVERING_JET_BLACK) && zebraSecondary==PresetColour.COVERING_WHITE)
					|| (zebraPrimary==PresetColour.COVERING_WHITE && (zebraSecondary==PresetColour.COVERING_BLACK || zebraSecondary==PresetColour.COVERING_JET_BLACK)))
				&& body.getTail().getType()==TailType.HORSE_MORPH_ZEBRA) {
					subspecies = Subspecies.HORSE_MORPH_ZEBRA;
				}
		}
			
		if(race==Race.HUMAN) {
			subspecies = Subspecies.HUMAN;
		}
		if(race==Race.REINDEER_MORPH) {
			subspecies = Subspecies.REINDEER_MORPH;
		}
		if(race==Race.SQUIRREL_MORPH) {
			subspecies = Subspecies.SQUIRREL_MORPH;
		}
		if(race==Race.RAT_MORPH) {
			subspecies = Subspecies.RAT_MORPH;
		}
		if(race==Race.BAT_MORPH) {
			subspecies = Subspecies.BAT_MORPH;
		}
		if(race==Race.WOLF_MORPH) {
			subspecies = Subspecies.WOLF_MORPH;
		}
		if(race==Race.SLIME) {
			subspecies = Subspecies.SLIME;
		}
		if(race==Race.RABBIT_MORPH) {
			subspecies = Subspecies.RABBIT_MORPH;
			if(body.getEar().getType()==EarType.RABBIT_MORPH_FLOPPY) {
				subspecies = Subspecies.RABBIT_MORPH_LOP;
			}
		}
		
		return subspecies;
	}
	
	private static void applyFoxColoring(Body body) {
		Colour c1 = body.getCoverings().get(BodyCoveringType.FOX_FUR).getPrimaryColour();
		Colour c2 = PresetColour.COVERING_WHITE;
		CoveringPattern pat = CoveringPattern.MARKED;
		
		if(c1==PresetColour.COVERING_BLACK) {
			c2 = c1;
			pat = CoveringPattern.NONE;
		}
		
		// Old:
//		if(c1==PresetColour.COVERING_BROWN) {
//			if(rand<0.5f) {
//				c2 = PresetColour.COVERING_BROWN;
//				pat = CoveringPattern.NONE;
//			} else {
//				c2 = PresetColour.COVERING_TAN;
//			}
//			
//		} else if(c1==PresetColour.COVERING_BROWN_DARK) {
//			if(rand<0.5f) {
//				c2 = PresetColour.COVERING_BROWN_DARK;
//				pat = CoveringPattern.NONE;
//			} else {
//				c2 = PresetColour.COVERING_BROWN;
//			}
//			
//		} else if(c1==PresetColour.COVERING_SILVER || c1==PresetColour.COVERING_GREY) {
//			if(rand<0.5f) {
//				c2 = c1;
//				pat = CoveringPattern.NONE;
//			}
//			
//		} else if(c1==PresetColour.COVERING_BLACK) {
//			if(rand<0.5f) {
//				c2 = PresetColour.COVERING_BLACK;
//				pat = CoveringPattern.NONE;
//			} else {
//				c2 = PresetColour.COVERING_GREY;
//			}
//			
//		} else if(c1==PresetColour.COVERING_TAN || c1==PresetColour.COVERING_WHITE) {
//			c2 = c1;
//			pat = CoveringPattern.NONE;
//			
//		} else {
//			// Set primary colour to GINGER if we have a colour that otherwise wouldn't be accounted for.
//			if(c1 != PresetColour.COVERING_BLONDE) {c1 = PresetColour.COVERING_GINGER;}
//			if(rand<0.025f) {
//				c2 = PresetColour.COVERING_BLACK;
//			} else if(rand<0.05f) {
//				c2 = PresetColour.COVERING_BROWN;
//			} else if(rand<0.5f) {
//				c2 = PresetColour.COVERING_GREY;
//			}
//		}
				
		body.getCoverings().put(BodyCoveringType.FOX_FUR, new Covering(BodyCoveringType.FOX_FUR, pat, c1, false, c2, false));
	}
	

	public static Body getPreGeneratedBody(GameCharacter linkedCharacter, Gender startingGender, GameCharacter mother, GameCharacter father) {
		return getPreGeneratedBody(linkedCharacter, startingGender, mother.getTrueSubspecies(), mother.getHalfDemonSubspecies(), father.getTrueSubspecies(), father.getHalfDemonSubspecies());
	}
	
	/**
	 * Only used for subspecies that have special offspring generation - i.e. demons.<br/><br/>
	 * 
	 * <b>Demon breeding</b><br/>
	 * Lilin<br/>
	 * + lilin = lilin<br/>
	 * + demon = demon<br/>
	 * + half-demon = half-demon<br/>
	 * + human half-demon = human half-demon<br/>
	 * + non-demon = half-demon<br/>
	 * + imps = alpha-imps<br/>
	 * Demon<br/>
	 * + lilin = demon<br/>
	 * + demon = demon<br/>
	 * + half-demon = half-demon<br/>
	 * + human half-demon = human half-demon<br/>
	 * + non-demon = half-demon<br/>
	 * + imps = alpha-imps<br/>
	 * Half-demon<br/>
	 * + lilin = half-demon<br/>
	 * + demon = half-demon<br/>
	 * + half-demon = half-demon<br/>
	 * + human half-demon = human half-demon<br/>
	 * + non-demon = half-demon<br/>
	 * + imps = alpha-imps<br/>
	 * Human half-demon<br/>
	 * + lilin = human half-demon<br/>
	 * + demon = human half-demon<br/>
	 * + half-demon = human half-demon<br/>
	 * + human half-demon = imps<br/>
	 * + non-demon = imps<br/>
	 * + imps = imps<br/>
	 * Imps and alpha-imps<br/>
	 * + anything = imps<br/>
	 * @return The pre-generated body to use as an offspring's core body.
	 */
	public static Body getPreGeneratedBody(GameCharacter linkedCharacter, Gender startingGender, Subspecies motherSubspecies, Subspecies motherHalfDemonSubspecies, Subspecies fatherSubspecies, Subspecies fatherHalfDemonSubspecies) {
		if(startingGender==null) {
			startingGender = Math.random()>0.5f?Gender.F_V_B_FEMALE:Gender.M_P_MALE;
		}
		
//		System.out.println(motherSubspecies.getName(mother));
		
		switch(motherSubspecies) {
			case ELDER_LILIN:
			case LILIN:
			case DEMON:
				switch(fatherSubspecies) {
					case ELDER_LILIN:
					case LILIN:
						if(motherSubspecies==Subspecies.ELDER_LILIN || motherSubspecies==Subspecies.LILIN) {
							return CharacterUtils.generateBody(linkedCharacter, startingGender, RacialBody.DEMON, Subspecies.LILIN, RaceStage.GREATER);
						} else {
							return CharacterUtils.generateBody(linkedCharacter, startingGender, RacialBody.DEMON, RaceStage.GREATER);
						}
					case DEMON:
						return CharacterUtils.generateBody(linkedCharacter, startingGender, RacialBody.DEMON, RaceStage.GREATER);
					case HALF_DEMON:
						return CharacterUtils.generateHalfDemonBody(linkedCharacter, startingGender, fatherHalfDemonSubspecies, true);
					case IMP:
					case IMP_ALPHA:
						return CharacterUtils.generateBody(linkedCharacter, startingGender, RacialBody.DEMON, Subspecies.IMP_ALPHA, RaceStage.GREATER);
					default:
						return CharacterUtils.generateHalfDemonBody(linkedCharacter, startingGender, fatherSubspecies, true);
				}
			case HALF_DEMON:
				if(motherHalfDemonSubspecies==Subspecies.HUMAN) {
					switch(fatherSubspecies) {
						case ELDER_LILIN:
						case LILIN:
						case DEMON:
						case HALF_DEMON:
							if(fatherHalfDemonSubspecies==Subspecies.HUMAN) {
								return CharacterUtils.generateBody(linkedCharacter, startingGender, RacialBody.DEMON, Subspecies.IMP, RaceStage.GREATER);	
							}
							return CharacterUtils.generateHalfDemonBody(linkedCharacter, startingGender, motherHalfDemonSubspecies, true);
						default:
							return CharacterUtils.generateBody(linkedCharacter, startingGender, RacialBody.DEMON, Subspecies.IMP, RaceStage.GREATER);
					}
					
				} else {
					switch(fatherSubspecies) {
						case ELDER_LILIN:
						case LILIN:
						case DEMON:
							return CharacterUtils.generateHalfDemonBody(linkedCharacter, startingGender, motherHalfDemonSubspecies, true);
						case HALF_DEMON: // If both are non-human half-demons, it's random as to whose species is birthed
							if(Math.random()<0.5f || fatherHalfDemonSubspecies==Subspecies.HUMAN) {
								return CharacterUtils.generateHalfDemonBody(linkedCharacter, startingGender, motherHalfDemonSubspecies, true);
							} else {
								return CharacterUtils.generateHalfDemonBody(linkedCharacter, startingGender, fatherHalfDemonSubspecies, true);
							}
						case IMP:
						case IMP_ALPHA:
							return CharacterUtils.generateBody(linkedCharacter, startingGender, RacialBody.DEMON, Subspecies.IMP_ALPHA, RaceStage.GREATER);
						default:
							return CharacterUtils.generateHalfDemonBody(linkedCharacter, startingGender, motherHalfDemonSubspecies, true);
					}
				}
			case IMP_ALPHA:
			case IMP:
				switch(fatherSubspecies) {
					case IMP:
						return CharacterUtils.generateBody(linkedCharacter, startingGender, RacialBody.DEMON, Subspecies.IMP, RaceStage.GREATER);
					default:
						return CharacterUtils.generateBody(linkedCharacter, startingGender, RacialBody.DEMON, Subspecies.IMP_ALPHA, RaceStage.GREATER);
				}
			default:
				switch(fatherSubspecies) {
					case ELDER_LILIN:
					case LILIN:
					case DEMON:
					case IMP:
					case IMP_ALPHA:
					case HALF_DEMON:
						 // Just return this method, but with mother & father swapped, as all demonic offspring types are unaffected by who is the mother or father:
						return getPreGeneratedBody(linkedCharacter, startingGender, fatherSubspecies, fatherHalfDemonSubspecies, motherSubspecies, motherHalfDemonSubspecies);
					default:
						return null;
				}
		}
	}
	
	public boolean isShortStature() {
		return false;
	}
	
	public boolean isNonBiped() {
		return false;
	}
	
	/**
	 * @return true if this SUbspecies is able to self-transform. Race.isAbleToSelfTransform() is factored into this.
	 */
	public boolean isAbleToSelfTransform() {
		return this.getRace().isAbleToSelfTransform();
	}
	
	public boolean isMainSubspecies() {
		return mainSubspecies;
	}

	private String getTaurEnding() {
		return feralName.charAt(feralName.length()-1)=='t'?"-taur":"taur";
	}
	
	protected String applyNonBipedNameChange(GameCharacter character, String baseName, boolean applyFeminineForm, boolean plural) {
		switch(character.getLegConfiguration()) {
			case ARACHNID:
				return baseName+"-arachne"+(plural?"s":"");
			case BIPEDAL:
				break;
			case CEPHALOPOD:
				return baseName+"-kraken"+(plural?"s":"");
			case TAIL:
				return "mer"+baseName+(plural?"s":"");
			case TAIL_LONG:
				return baseName+"-lamia"+(plural?"s":"");
			case TAUR:
				return baseName+getTaurEnding()+(applyFeminineForm?"ess"+(plural?"es":""):(plural?"s":""));
		}
		return baseName;
	}
	
	/**
	 * @param   The character whose subspecies's name is to be returned. Can pass in null.
	 * @return  The singular name of this character's subspecies.
	 */
	public String getName(GameCharacter character) {
		if(character!=null && character.getLegConfiguration()!=LegConfiguration.BIPEDAL && !isNonBiped()) {
			return applyNonBipedNameChange(character, getFeralName(character), false, false);
		}
		return name;
	}

	/**
	 * @param   The character whose subspecies's pluralised name is to be returned. Can pass in null.
	 * @return  The plural name of this character's subspecies.
	 */
	public String getNamePlural(GameCharacter character) {
		if(character!=null && character.getLegConfiguration()!=LegConfiguration.BIPEDAL && !isNonBiped()) {
			return applyNonBipedNameChange(character, getFeralName(character), false, true);
		}
		return namePlural;
	}
	
	/**
	 * @param   The character whose male subspecies name is to be returned. Can pass in null.
	 * @return  The singular male name of this character's subspecies.
	 */
	public String getSingularMaleName(GameCharacter character) {
		if(character!=null && character.getLegConfiguration()!=LegConfiguration.BIPEDAL && !isNonBiped()) {
			return applyNonBipedNameChange(character, getFeralName(character), false, false);
		}

		if(Main.game.isSillyModeEnabled() && character!=null) {
			if(character.getSubspecies() == Subspecies.WOLF_MORPH && Main.game.isSillyModeEnabled()){
				return "awoo-boi";
			} else if(character.getSubspecies() == Subspecies.CAT_MORPH && Main.game.isSillyModeEnabled()){
				return "catte-boi";
			} else if(character.getSubspecies() == Subspecies.HARPY && Main.game.isSillyModeEnabled()){
				return "birb";
			}
		}
		return singularMaleName;
	}

	/**
	 * @param   The character whose female subspecies name is to be returned. Can pass in null.
	 * @return  The singular female name of this character's subspecies.
	 */
	public String getSingularFemaleName(GameCharacter character) {
		if(character!=null && character.getLegConfiguration()!=LegConfiguration.BIPEDAL && !isNonBiped()) {
			return applyNonBipedNameChange(character, getFeralName(character), true, false);
		}
		
		if(Main.game.isSillyModeEnabled() && character!=null) {
			if(character.getSubspecies() == Subspecies.WOLF_MORPH){
				return "awoo-girl";
			} else if(character.getSubspecies() == Subspecies.CAT_MORPH && Main.game.isSillyModeEnabled()){
				return "catte-girl";
			} else if(character.getSubspecies() == Subspecies.HARPY && Main.game.isSillyModeEnabled()){
				return "birb";
			}
		}
		
		return singularFemaleName;
	}

	/**
	 * @param   The character whose male subspecies's pluralised name is to be returned. Can pass in null.
	 * @return  The plural male name of this character's subspecies.
	 */
	public String getPluralMaleName(GameCharacter character) {
		if(character!=null && character.getLegConfiguration()!=LegConfiguration.BIPEDAL && !isNonBiped()) {
			return applyNonBipedNameChange(character, getFeralName(character), false, true);
		}
		return pluralMaleName;
	}

	/**
	 * @param   The character whose female subspecies's pluralised name is to be returned. Can pass in null.
	 * @return  The plural female name of this character's subspecies.
	 */
	public String getPluralFemaleName(GameCharacter character) {
		if(character!=null && character.getLegConfiguration()!=LegConfiguration.BIPEDAL && !isNonBiped()) {
			return applyNonBipedNameChange(character, getFeralName(character), false, true);
		}
		return pluralFemaleName;
	}

	public String getFeralName(GameCharacter character) {
		return feralName;
	}

	public String getStatusEffectDescription(GameCharacter character) {
		return UtilText.parse(character, statusEffectDescription);
	}

	public Map<Attribute, Float> getStatusEffectAttributeModifiers(GameCharacter character) {
		return statusEffectAttributeModifiers;
	}

	public Map<PerkCategory, Integer> getPerkWeighting(GameCharacter character) {
		if(character==null || !character.isFeminine()) {
			return perkWeightingMasculine;
		}
		return perkWeightingFeminine;
	}
	
	public List<String> getExtraEffects(GameCharacter character) {
		if(character!=null) {
			List<String> effectsModified = new ArrayList<>(extraEffects);
			
			int landSpeed = character.getLegConfiguration().getLandSpeedModifier();
			int waterSpeed =  character.getLegConfiguration().getWaterSpeedModifier();
			if(landSpeed!=0) {
				effectsModified.add((landSpeed<0?"[style.boldExcellent("+landSpeed+"%)]":"[style.boldTerrible(+"+landSpeed+"%)]")+" travel time on land");
			}
			if(waterSpeed!=0) {
				effectsModified.add((waterSpeed<0?"[style.boldExcellent("+waterSpeed+"%)]":"[style.boldTerrible(+"+waterSpeed+"%)]")+" travel time in water");
			}
			
			return effectsModified;
		}
		return extraEffects;
	}

	public String getBookName() {
		return bookName;
	}

	public String getBookNamePlural() {
		return bookNamePlural;
	}

	public String getBasicDescription(GameCharacter character) {
		return UtilText.parseFromXMLFile("characters/raceInfo", getBasicDescriptionId());
	}

	public String getAdvancedDescription(GameCharacter character) {
		return UtilText.parseFromXMLFile("characters/raceInfo", getAdvancedDescriptionId());
	}
	
	public String getBasicDescriptionId() {
		return basicDescriptionId;
	}

	public String getAdvancedDescriptionId() {
		return advancedDescriptionId;
	}

	public AbstractRace getRace() {
		return race;
	}

	public Attribute getDamageMultiplier() {
		return getRace().getDefaultDamageMultiplier();
	}
	
	public Colour getColour(GameCharacter character) {
		return colour;
	}
	
	public SubspeciesPreference getSubspeciesPreferenceDefault() {
		return subspeciesPreferenceDefault;
	}
	
	public String getDescription(GameCharacter character) {
		return description;
	}
	
	protected String getBipedBackground(String svg, GameCharacter character, Colour colour) {//TODO - when support other body types, add different backgrounds
		String returnString = svg;
		if(character!=null && character.getLegConfiguration()!=LegConfiguration.BIPEDAL) {
			try {
				String SVGStringLegConfigurationBackground = "";
				InputStream is = this.getClass().getResourceAsStream("/com/lilithsthrone/res/statusEffects/race/raceBackgroundNonBiped.svg");
				SVGStringLegConfigurationBackground = "<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+Util.inputStreamToString(is)+"</div>";
				is.close();
				SVGStringLegConfigurationBackground = SvgUtil.colourReplacement(this.toString()+"NBPID",
						colour,
						colour,
						colour,
						SVGStringLegConfigurationBackground);
				
				returnString = SVGStringLegConfigurationBackground + "<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>" + svg +"</div>";
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(character!=null && (character.isTorsoBestial() || (character.isElemental() && !((Elemental)character).getSummoner().isElementalActive()))) {
			try {
				String feralBackground = "";
				InputStream is = this.getClass().getResourceAsStream("/com/lilithsthrone/res/statusEffects/race/raceBackgroundFeral.svg");
				feralBackground = "<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+Util.inputStreamToString(is)+"</div>";
				is.close();
				feralBackground = SvgUtil.colourReplacement(this.toString()+"FERAL",
						colour,
						colour,
						colour,
						feralBackground);
				
				returnString = returnString + "<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>" + feralBackground +"</div>";
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return returnString;
	}
	
	public String getSVGString(GameCharacter character) {
		return getBipedBackground(SVGString, character, this.getColour(character));
	}
	
	public String getSVGStringNoBackground() {
		return SVGStringNoBackground;
	}

	public String getSVGStringDesaturated(GameCharacter character) {
		return getBipedBackground(SVGStringDesaturated, character, PresetColour.BASE_GREY);
	}

	public String getSlimeSVGString(GameCharacter character) {
		return getBipedBackground(slimeSVGString, character, PresetColour.RACE_SLIME);
	}

	public String getHalfDemonSVGString(GameCharacter character) {
		if(character!=null && character.getSubspeciesOverride()!=null && character.getSubspeciesOverride().equals(Subspecies.DEMON)) {
			return getBipedBackground(demonSVGString, character, PresetColour.RACE_DEMON);
		} else {
			return getBipedBackground(halfDemonSVGString, character, PresetColour.RACE_HALF_DEMON);
		}
	}

	public Map<AbstractWorldType, SubspeciesSpawnRarity> getWorldLocations() {
		return worldLocations;
	}

	public List<SubspeciesFlag> getFlags() {
		return flags;
	}
	
	public boolean hasFlag(SubspeciesFlag flag) {
		return getFlags().contains(flag);
	}

	/**
	 * @param worldType The WorldType from which to fetch Subspecies present.
	 * @param onlyCoreRaceSpecies true if only core Subspecies should be returned. (e.g. Cat-morph would be returned, but not Lion-morph, Tiger-morph, etc.)
	 * @param subspeciesToExclude Any Subspecies that should be excluded from the returned map.
	 */
	public static Map<Subspecies, SubspeciesSpawnRarity> getWorldSpecies(AbstractWorldType worldType, boolean onlyCoreRaceSpecies, Subspecies... subspeciesToExclude) {
		worldSpecies.putIfAbsent(worldType, new HashMap<>());
		
		Map<Subspecies, SubspeciesSpawnRarity> map = new HashMap<>(worldSpecies.get(worldType));
		if(onlyCoreRaceSpecies) {
			for(Subspecies sub : worldSpecies.get(worldType).keySet()) {
				if(Subspecies.getMainSubspeciesOfRace(sub.getRace())!=sub) {
					map.remove(sub);
				}
			}
		}
		
		for(Subspecies sub : subspeciesToExclude) {
			map.remove(sub);
		}
		
		return map;
	}

	/**
	 * @param onlyCoreRaceSpecies true if only core Subspecies should be returned. (e.g. Cat-morph would be returned, but not Lion-morph, Tiger-morph, etc.)
	 * @param subspeciesToExclude Any Subspecies that should be excluded from the returned map.
	 */
	public static Map<Subspecies, SubspeciesSpawnRarity> getDominionStormImmuneSpecies(boolean onlyCoreRaceSpecies, Subspecies... subspeciesToExclude) {
		Map<Subspecies, SubspeciesSpawnRarity> map = new HashMap<>(dominionStormImmuneSpecies);
		
		if(onlyCoreRaceSpecies) {
			for(Subspecies sub : dominionStormImmuneSpecies.keySet()) {
				if(Subspecies.getMainSubspeciesOfRace(sub.getRace())!=sub) {
					map.remove(sub);
				}
			}
		}
		
		for(Subspecies sub : subspeciesToExclude) {
			map.remove(sub);
		}
		
		return map;
	}

	public static List<Subspecies> getSubspeciesOfRace(AbstractRace race) {
		return subspeciesFromRace.get(race);
	}
	
	/**
	 * @return A String array of length 6, consisting of:<br/>
	 * <b>[0]:</b> Singular generic demon name<br/>
	 * <b>[1]:</b> Plural generic demon name<br/>
	 * <b>[2]:</b> Singular male demon name<br/>
	 * <b>[3]:</b> Singular female demon name<br/>
	 * <b>[4]:</b> Plural male demon name<br/>
	 * <b>[5]:</b> Plural female demon name<br/>
	 */
	public String[] getHalfDemonName(GameCharacter character) {
		String[] names = null;
		
		if(this.getRace()==Race.DEMON
				|| this.getRace()==Race.ELEMENTAL
				|| this.getRace()==Race.HUMAN) {
			names = new String[] {
				"half-demon",
				"half-demons",
				"half-incubus",
				"half-succubus",
				"half-incubi",
				"half-succubi"};	
		}
		
		if(names==null) {
			if(character==null) {
				names = new String[] {
						"demonic-"+name,
						"demonic-"+namePlural,
						"demonic-"+singularMaleName,
						"demonic-"+singularFemaleName,
						"demonic-"+pluralMaleName,
						"demonic-"+pluralFemaleName};
				
			} else {
				names = new String[] {
						"demonic-"+this.getName(character),
						"demonic-"+this.getNamePlural(character),
						"demonic-"+this.getSingularMaleName(character),
						"demonic-"+this.getSingularFemaleName(character),
						"demonic-"+this.getPluralMaleName(character),
						"demonic-"+this.getPluralFemaleName(character)};
			}
		}
		
		return names;
	}

	public FurryPreference getDefaultFemininePreference() {
		if(this.isNonBiped()) {
			return FurryPreference.MINIMUM;
		}
		return this.getRace().getDefaultFemininePreference();
	}

	public FurryPreference getDefaultMasculinePreference() {
		if(this.isNonBiped()) {
			return FurryPreference.MINIMUM;
		}
		return this.getRace().getDefaultMasculinePreference();
	}

	/**
	 * @return true if this subspecies should be displayed in the furry preferences options screen.
	 */
	public boolean isDisplayedInFurryPreferences() {
		return !this.hasFlag(SubspeciesFlag.HIDDEN_FROM_PREFERENCES);
	}

	/**
	 * @return true if this subspecies can have its FurryPreference modified in the furry preferences options screen.
	 */
	public boolean isFurryPreferencesEnabled() {
		return !this.hasFlag(SubspeciesFlag.DISBALE_FURRY_PREFERENCE);
	}

	/**
	 * @return true if this subspecies can have its spawn frequency modified in the furry preferences options screen.
	 */
	public boolean isSpawnPreferencesEnabled() {
		return !this.hasFlag(SubspeciesFlag.DISBALE_SPAWN_PREFERENCE);
	}
	
	public int getBaseSlaveValue(GameCharacter character) {
		switch(this) {
			case ANGEL:
				return 80000;
			case CAT_MORPH:
			case CAT_MORPH_CARACAL:
			case CAT_MORPH_CHEETAH:
			case CAT_MORPH_LEOPARD:
			case CAT_MORPH_LEOPARD_SNOW:
			case CAT_MORPH_LION:
			case CAT_MORPH_LYNX:
			case CAT_MORPH_TIGER:
				return 12000;
			case DOG_MORPH:
			case DOG_MORPH_BORDER_COLLIE:
			case DOG_MORPH_DOBERMANN:
			case DOG_MORPH_GERMAN_SHEPHERD:
				return 8000;
			case COW_MORPH:
				return 15000;
			case HORSE_MORPH:
			case HORSE_MORPH_ZEBRA:
			case REINDEER_MORPH:
				return 18000;
			case HORSE_MORPH_PEGASUS:
				return 24000;
			case HORSE_MORPH_UNICORN:
				return 30000;
			case HORSE_MORPH_ALICORN:
				return 60000;
			case CENTAUR:
				return 25000;
			case PEGATAUR:
				return 35000;
			case UNITAUR:
				return 50000;
			case ALITAUR:
				return 100000;
			case LILIN:
				return 500000000;
			case ELDER_LILIN:
				return 1000000000;
			case HALF_DEMON:
				return 50000;
			case DEMON:
				return 120000;
			case ELEMENTAL_AIR:
			case ELEMENTAL_ARCANE:
			case ELEMENTAL_EARTH:
			case ELEMENTAL_FIRE:
			case ELEMENTAL_WATER:
				return 100000;
			case IMP:
			case IMP_ALPHA:
				return 1000;
			case HARPY:
			case HARPY_BALD_EAGLE:
			case HARPY_RAVEN:
				return 12000;
			case HARPY_PHOENIX:
				return 50_000;
			case HUMAN:
				return 4000;
			case SQUIRREL_MORPH:
				return 6000;
			case ALLIGATOR_MORPH:
				return 10000;
			case WOLF_MORPH:
				return 10000;
			case FOX_MORPH:
			case FOX_MORPH_FENNEC:
				return 8000;
			case FOX_MORPH_ARCTIC:
				return 10_000;
			case FOX_ASCENDANT:
			case FOX_ASCENDANT_ARCTIC:
			case FOX_ASCENDANT_FENNEC:
				return 15000 * character.getTailCount();
			case BAT_MORPH:
				return 10000;
			case RAT_MORPH:
				return 6000;
			case RABBIT_MORPH:
			case RABBIT_MORPH_LOP:
				return 12000;
			case SLIME:
				return 10000;
		}
		
		return 10000;
	}
	
	public static Map<Subspecies, Integer> getGenericSexPartnerSubspeciesMap(Gender gender, Subspecies... subspeciesToExclude) {
		Map<Subspecies, Integer> availableRaces = new HashMap<>();
		List<Subspecies> subspecies = Util.newArrayListOfValues(Subspecies.values());
		subspecies.removeAll(Arrays.asList(subspeciesToExclude));
		
		for(Subspecies s : subspecies) {
			if(s==Subspecies.REINDEER_MORPH
					&& Main.game.getSeason()==Season.WINTER
					&& Main.game.getDialogueFlags().hasFlag(DialogueFlagValue.hasSnowedThisWinter)) {
				addToSubspeciesMap(10, gender, s, availableRaces);
				
			} else if(s.getRace()!=Race.DEMON
					&& s.getRace()!=Race.ANGEL
					&& s.getRace()!=Race.ELEMENTAL
					&& s!=Subspecies.FOX_ASCENDANT
					&& s!=Subspecies.FOX_ASCENDANT_FENNEC
					&& s!=Subspecies.FOX_ASCENDANT_ARCTIC
					&& s!=Subspecies.SLIME) {
				if(Subspecies.getMainSubspeciesOfRace(s.getRace())==s) {
					addToSubspeciesMap(10, gender, s, availableRaces);
				} else {
					addToSubspeciesMap(3, gender, s, availableRaces);
				}
			}
		}
		
		return availableRaces;
	}

	public static void addToSubspeciesMap(int weight, Gender gender, Subspecies subspecies, Map<Subspecies, Integer> map) {
		addToSubspeciesMap(weight, gender, subspecies, map, null);
	}
	
	public static void addToSubspeciesMap(int weight, Gender gender, Subspecies subspecies, Map<Subspecies, Integer> map, SubspeciesPreference userPreferenceOverride) {
		if(gender.isFeminine()) {
			if((Main.getProperties().getSubspeciesFeminineFurryPreferencesMap().get(subspecies)!=FurryPreference.HUMAN && Main.getProperties().getSubspeciesFemininePreferencesMap().get(subspecies).getValue()>0)
					|| userPreferenceOverride!=null) {
				map.put(subspecies, weight*(userPreferenceOverride!=null?userPreferenceOverride:Main.getProperties().getSubspeciesFemininePreferencesMap().get(subspecies)).getValue());
			}
			
		} else {
			if((Main.getProperties().getSubspeciesMasculineFurryPreferencesMap().get(subspecies)!=FurryPreference.HUMAN && Main.getProperties().getSubspeciesMasculinePreferencesMap().get(subspecies).getValue()>0)
					|| userPreferenceOverride!=null) {
				map.put(subspecies, weight*(userPreferenceOverride!=null?userPreferenceOverride:Main.getProperties().getSubspeciesMasculinePreferencesMap().get(subspecies)).getValue());
			}
		}
	}
}