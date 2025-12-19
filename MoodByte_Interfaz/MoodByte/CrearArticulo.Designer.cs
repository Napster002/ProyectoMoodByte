namespace MoodByte
{
    partial class CrearArticulo
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
            lblTitulo = new Label();
            lblSubtitulo = new Label();
            lblEnlace = new Label();
            lblImagen = new Label();
            txtTitulo = new TextBox();
            txtSubtitulo = new TextBox();
            txtEnlace = new TextBox();
            txtImagen = new TextBox();
            btnGuardar = new Button();
            SuspendLayout();
            // 
            // lblTitulo
            // 
            lblTitulo.AutoSize = true;
            lblTitulo.Location = new Point(204, 68);
            lblTitulo.Name = "lblTitulo";
            lblTitulo.Size = new Size(41, 15);
            lblTitulo.TabIndex = 0;
            lblTitulo.Text = "Titulo:";
            // 
            // lblSubtitulo
            // 
            lblSubtitulo.AutoSize = true;
            lblSubtitulo.Location = new Point(204, 142);
            lblSubtitulo.Name = "lblSubtitulo";
            lblSubtitulo.Size = new Size(58, 15);
            lblSubtitulo.TabIndex = 1;
            lblSubtitulo.Text = "Subtítulo:";
            // 
            // lblEnlace
            // 
            lblEnlace.AutoSize = true;
            lblEnlace.Location = new Point(204, 212);
            lblEnlace.Name = "lblEnlace";
            lblEnlace.Size = new Size(44, 15);
            lblEnlace.TabIndex = 2;
            lblEnlace.Text = "Enlace:";
            // 
            // lblImagen
            // 
            lblImagen.AutoSize = true;
            lblImagen.Location = new Point(204, 290);
            lblImagen.Name = "lblImagen";
            lblImagen.Size = new Size(50, 15);
            lblImagen.TabIndex = 3;
            lblImagen.Text = "Imagen:";
            // 
            // txtTitulo
            // 
            txtTitulo.Location = new Point(333, 68);
            txtTitulo.Name = "txtTitulo";
            txtTitulo.Size = new Size(194, 23);
            txtTitulo.TabIndex = 4;
            // 
            // txtSubtitulo
            // 
            txtSubtitulo.Location = new Point(333, 142);
            txtSubtitulo.Name = "txtSubtitulo";
            txtSubtitulo.Size = new Size(194, 23);
            txtSubtitulo.TabIndex = 5;
            // 
            // txtEnlace
            // 
            txtEnlace.Location = new Point(333, 212);
            txtEnlace.Name = "txtEnlace";
            txtEnlace.Size = new Size(194, 23);
            txtEnlace.TabIndex = 6;
            // 
            // txtImagen
            // 
            txtImagen.Location = new Point(333, 290);
            txtImagen.Name = "txtImagen";
            txtImagen.Size = new Size(194, 23);
            txtImagen.TabIndex = 7;
            // 
            // btnGuardar
            // 
            btnGuardar.Location = new Point(452, 369);
            btnGuardar.Name = "btnGuardar";
            btnGuardar.Size = new Size(75, 23);
            btnGuardar.TabIndex = 8;
            btnGuardar.Text = "Guardar";
            btnGuardar.UseVisualStyleBackColor = true;
            btnGuardar.Click += btnGuardar_Click;
            // 
            // CrearArticulo
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(btnGuardar);
            Controls.Add(txtImagen);
            Controls.Add(txtEnlace);
            Controls.Add(txtSubtitulo);
            Controls.Add(txtTitulo);
            Controls.Add(lblImagen);
            Controls.Add(lblEnlace);
            Controls.Add(lblSubtitulo);
            Controls.Add(lblTitulo);
            Name = "CrearArticulo";
            Text = "CrearArticulo";
            Load += CrearArticulo_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label lblTitulo;
        private Label lblSubtitulo;
        private Label lblEnlace;
        private Label lblImagen;
        private TextBox txtTitulo;
        private TextBox txtSubtitulo;
        private TextBox txtEnlace;
        private TextBox txtImagen;
        private Button btnGuardar;
    }
}