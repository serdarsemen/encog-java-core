/*
 * Encog(tm) Core v2.4
 * http://www.heatonresearch.com/encog/
 * http://code.google.com/p/encog-java/
 * 
 * Copyright 2008-2010 by Heaton Research Inc.
 * 
 * Released under the LGPL.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 * 
 * Encog and Heaton Research are Trademarks of Heaton Research, Inc.
 * For information on Heaton Research trademarks, visit:
 * 
 * http://www.heatonresearch.com/copyright.html
 */

package org.encog.neural.networks.training.neat;

import org.encog.neural.networks.synapse.neat.NEATNeuronType;
import org.encog.solve.genetic.innovation.BasicInnovation;

/**
 * Implements a NEAT innovation.  This lets NEAT track what changes it has previously
 * tried with a neural network.
 * 
 * NeuroEvolution of Augmenting Topologies (NEAT) is a genetic algorithm for the
 * generation of evolving artificial neural networks. It was developed by Ken
 * Stanley while at The University of Texas at Austin.
 * 
 * http://www.cs.ucf.edu/~kstanley/
 * 
 */
public class NEATInnovation extends BasicInnovation {

	private final int fromNeuronID;
	private final NEATInnovationType innovationType;
	private int neuronID;
	private final NEATNeuronType neuronType;
	private final double splitX;
	private final double splitY;
	private final int toNeuronID;

	public NEATInnovation(final int fromNeuronID, final int toNeuronID,
			final NEATInnovationType innovationType, final int innovationID) {

		this.fromNeuronID = fromNeuronID;
		this.toNeuronID = toNeuronID;
		this.innovationType = innovationType;
		setInnovationID(innovationID);

		neuronID = -1;
		splitX = 0;
		splitY = 0;
		neuronType = NEATNeuronType.None;
	}

	public NEATInnovation(final int fromNeuronID, final int toNeuronID,
			final NEATInnovationType innovationType, final int innovationID,
			final NEATNeuronType neuronType, final double x, final double y) {
		this.fromNeuronID = fromNeuronID;
		this.toNeuronID = toNeuronID;
		this.innovationType = innovationType;
		setInnovationID(innovationID);
		this.neuronType = neuronType;
		splitX = x;
		splitY = y;

		neuronID = 0;
	}

	public NEATInnovation(final NEATNeuronGene neuronGene,
			final int innovationID, final int neuronID) {

		this.neuronID = neuronID;
		setInnovationID(innovationID);
		splitX = neuronGene.getSplitX();
		splitY = neuronGene.getSplitY();

		neuronType = neuronGene.getNeuronType();
		innovationType = NEATInnovationType.NewNeuron;
		fromNeuronID = -1;
		toNeuronID = -1;
	}

	public int getFromNeuronID() {
		return fromNeuronID;
	}

	public NEATInnovationType getInnovationType() {
		return innovationType;
	}

	public int getNeuronID() {
		return neuronID;
	}

	public NEATNeuronType getNeuronType() {
		return neuronType;
	}

	public double getSplitX() {
		return splitX;
	}

	public double getSplitY() {
		return splitY;
	}

	public int getToNeuronID() {
		return toNeuronID;
	}

	public void setNeuronID(final int neuronID) {
		this.neuronID = neuronID;
	}

}