import { Ingredient } from './ingredient.model';

export interface Potion {
    id: number;
    title: string;
    description?: string;
    brewed: boolean;
    createdAt: string;
    ingredients?: Ingredient[];
    pointsEarned?: number;
}