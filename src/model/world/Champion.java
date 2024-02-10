package model.world;

import java.awt.Point;

import java.util.ArrayList;

import engine.Game;
import model.abilities.Ability;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.effects.Effect;

@SuppressWarnings("rawtypes")
public abstract class Champion implements Damageable,Comparable {
	private String name;
	private int maxHP;
	private int currentHP;
	private int mana;
	private int maxActionPointsPerTurn;
	private int currentActionPoints;
	private int attackRange;
	private int attackDamage;
	private int speed;
	private ArrayList<Ability> abilities;
	private ArrayList<Effect> appliedEffects;
	private Condition condition;
	private Point location;
	

	public Champion(String name, int maxHP, int mana, int actions, int speed, int attackRange, int attackDamage) {
		this.name = name;
		this.maxHP = maxHP;
		this.mana = mana;
		this.currentHP = this.maxHP;
		this.maxActionPointsPerTurn = actions;
		this.speed = speed;
		this.attackRange = attackRange;
		this.attackDamage = attackDamage;
		this.condition = Condition.ACTIVE;
		this.abilities = new ArrayList<Ability>();
		this.appliedEffects = new ArrayList<Effect>();
		this.currentActionPoints=maxActionPointsPerTurn;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public String getName() {
		return name;
	}

	public void setCurrentHP(int hp) {

		if (hp <= 0) {
			currentHP = 0;
			condition=Condition.KNOCKEDOUT;
			
		} 
		else if (hp > maxHP)
			currentHP = maxHP;
		else
			currentHP = hp;

	}

	
	public int getCurrentHP() {

		return currentHP;
	}

	public ArrayList<Effect> getAppliedEffects() {
		return appliedEffects;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int currentSpeed) {
		if (currentSpeed < 0)
			this.speed = 0;
		else
			this.speed = currentSpeed;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point currentLocation) {
		this.location = currentLocation;
	}

	public int getAttackRange() {
		return attackRange;
	}

	public ArrayList<Ability> getAbilities() {
		return abilities;
	}

	public int getCurrentActionPoints() {
		return currentActionPoints;
	}

	public void setCurrentActionPoints(int currentActionPoints) {
		if(currentActionPoints>maxActionPointsPerTurn)
			currentActionPoints=maxActionPointsPerTurn;
		else 
			if(currentActionPoints<0)
			currentActionPoints=0;
		this.currentActionPoints = currentActionPoints;
	}

	public int getMaxActionPointsPerTurn() {
		return maxActionPointsPerTurn;
	}

	public void setMaxActionPointsPerTurn(int maxActionPointsPerTurn) {
		this.maxActionPointsPerTurn = maxActionPointsPerTurn;
	}

	public int compareTo(Object o)
	{
		Champion c = (Champion)o;
		if(speed==c.speed)
			return name.compareTo(c.name);
		return -1 * (speed-c.speed);
	}
	public String toString()
	{
	   String r =" ";
	     
			r=  " Name: " + this.getName() + "\n" + "MaxHP: " + this.getMaxHP() + "\n" + " Mana :" + this.getMana() + "\n" + "ActionPoints:"
		       + this.getMaxActionPointsPerTurn() + "\n" + "Speed: " + this.getSpeed() + "\n" + "AttackRange" + this.getAttackRange()
				+ "\n" + "AttackDamage: " + this.getAttackDamage()+"\n" + "currHP: " + this.getCurrentHP();
				
		//}
		return r;
	}
	public String championj()
	{
		String r="";
		r=/*" type: " + this.getName() + "\n" +*/ "currHp: " + this.getCurrentHP() + 
				"\n" + " Mana :" + this.getMana() + "\n" + "ActionPoints:"
			       + this.getCurrentActionPoints() + "\n"  + "AttackRange" + this.getAttackRange()
					+ "\n" + "AttackDamage: " + this.getAttackDamage();
		return r;
	}
	
	
	
	public String championabilityname()
	{
		String r="";
		for(int i=0;i<this.getAbilities().size();i++)
		{
			r="Name: "+this.getAbilities().get(i).getName()+"\n"+
			  "Area of Effect: "+this.getAbilities().get(i).getCastArea()+"\n"+
			  "cast range: "+this.getAbilities().get(i).getCastRange()+"\n"+
			  "action point required: "+this.getAbilities().get(i).getRequiredActionPoints()+"\n"+
			  "currunt cooldown: "+this.getAbilities().get(i).getCurrentCooldown()+"\n"+
			  "base cooldown: "+this.getAbilities().get(i).getBaseCooldown()+"\n"+
			  "mana cost: "+this.getAbilities().get(i).getManaCost()+"\n";
			if(this.getAbilities().get(i) instanceof HealingAbility)
			{
				HealingAbility c=(HealingAbility) this.getAbilities().get(i);
				r=r+"type: HealingAbility"+"\n"+"heal amount: "+c.getHealAmount();
			}
			else if(this.getAbilities().get(i) instanceof DamagingAbility)
			{
				DamagingAbility c=(DamagingAbility) this.getAbilities().get(i);
				r=r+"type: DamagingAbility"+"\n"+"damage amount: "+c.getDamageAmount();
			}
			else if(this.getAbilities().get(i) instanceof CrowdControlAbility)
			{
				CrowdControlAbility c=(CrowdControlAbility)this.getAbilities().get(i);
				r=r+"type: CrowdControlAbility"+"\n"+"duration: "+c.getEffect().getDuration()
					+"\n"+"name: "+c.getEffect().getName();
			}
		}
		
		return r;
	
	}
	public String championeffectname()
	{
		String r="";
		for(int i=0;i<this.getAppliedEffects().size();i++)
		{
			r=r+this.getAppliedEffects().get(i);
		}
		return r;
	}
	
public abstract void useLeaderAbility(ArrayList<Champion> targets);
}
