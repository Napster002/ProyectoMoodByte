namespace MoodByte
{
    partial class CrearEjercicio
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            lblEstado = new Label();
            lblTitulo = new Label();
            lblDescripcion = new Label();
            lblDuracion = new Label();
            cmbEstado = new ComboBox();
            txtTitulo = new TextBox();
            txtDescripcion = new TextBox();
            txtDuracion = new TextBox();
            btnGuardar = new Button();
            SuspendLayout();
            // 
            // lblEstado
            // 
            lblEstado.AutoSize = true;
            lblEstado.Location = new Point(230, 39);
            lblEstado.Name = "lblEstado";
            lblEstado.Size = new Size(45, 15);
            lblEstado.TabIndex = 0;
            lblEstado.Text = "Estado:";
            // 
            // lblTitulo
            // 
            lblTitulo.AutoSize = true;
            lblTitulo.Location = new Point(230, 190);
            lblTitulo.Name = "lblTitulo";
            lblTitulo.Size = new Size(41, 15);
            lblTitulo.TabIndex = 1;
            lblTitulo.Text = "Titulo:";
            // 
            // lblDescripcion
            // 
            lblDescripcion.AutoSize = true;
            lblDescripcion.Location = new Point(199, 261);
            lblDescripcion.Name = "lblDescripcion";
            lblDescripcion.Size = new Size(72, 15);
            lblDescripcion.TabIndex = 2;
            lblDescripcion.Text = "Descripcion:";
            // 
            // lblDuracion
            // 
            lblDuracion.AutoSize = true;
            lblDuracion.Location = new Point(213, 116);
            lblDuracion.Name = "lblDuracion";
            lblDuracion.Size = new Size(58, 15);
            lblDuracion.TabIndex = 3;
            lblDuracion.Text = "Duracion:";
            // 
            // cmbEstado
            // 
            cmbEstado.FormattingEnabled = true;
            cmbEstado.Location = new Point(300, 38);
            cmbEstado.Name = "cmbEstado";
            cmbEstado.Size = new Size(121, 23);
            cmbEstado.TabIndex = 4;
            // 
            // txtTitulo
            // 
            txtTitulo.Location = new Point(300, 190);
            txtTitulo.Name = "txtTitulo";
            txtTitulo.Size = new Size(168, 23);
            txtTitulo.TabIndex = 5;
            // 
            // txtDescripcion
            // 
            txtDescripcion.Location = new Point(300, 261);
            txtDescripcion.Multiline = true;
            txtDescripcion.Name = "txtDescripcion";
            txtDescripcion.Size = new Size(281, 106);
            txtDescripcion.TabIndex = 6;
            // 
            // txtDuracion
            // 
            txtDuracion.Location = new Point(300, 116);
            txtDuracion.Name = "txtDuracion";
            txtDuracion.Size = new Size(121, 23);
            txtDuracion.TabIndex = 7;
            // 
            // btnGuardar
            // 
            btnGuardar.Location = new Point(506, 391);
            btnGuardar.Name = "btnGuardar";
            btnGuardar.Size = new Size(75, 23);
            btnGuardar.TabIndex = 8;
            btnGuardar.Text = "Guardar";
            btnGuardar.UseVisualStyleBackColor = true;
            // 
            // CrearEjercicio
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(btnGuardar);
            Controls.Add(txtDuracion);
            Controls.Add(txtDescripcion);
            Controls.Add(txtTitulo);
            Controls.Add(cmbEstado);
            Controls.Add(lblDuracion);
            Controls.Add(lblDescripcion);
            Controls.Add(lblTitulo);
            Controls.Add(lblEstado);
            Name = "CrearEjercicio";
            Text = "CrearEjercicio";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label lblEstado;
        private Label lblTitulo;
        private Label lblDescripcion;
        private Label lblDuracion;
        private ComboBox cmbEstado;
        private TextBox txtTitulo;
        private TextBox txtDescripcion;
        private TextBox txtDuracion;
        private Button btnGuardar;
    }
}