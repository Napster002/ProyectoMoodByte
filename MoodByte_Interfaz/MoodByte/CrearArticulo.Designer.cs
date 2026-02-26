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
            components = new System.ComponentModel.Container();
            lblTitulo = new Label();
            lblSubtitulo = new Label();
            lblEnlace = new Label();
            lblImagen = new Label();
            txtTitulo = new TextBox();
            txtSubtitulo = new TextBox();
            txtEnlace = new TextBox();
            txtImagen = new TextBox();
            btnGuardar = new Button();
            buttonLimpiar = new Button();
            epArticulo = new ErrorProvider(components);
            ((System.ComponentModel.ISupportInitialize)epArticulo).BeginInit();
            SuspendLayout();
            // 
            // lblTitulo
            // 
            lblTitulo.AutoSize = true;
            lblTitulo.Font = new Font("Segoe UI", 10.2F, FontStyle.Bold);
            lblTitulo.ForeColor = Color.FromArgb(245, 109, 95);
            lblTitulo.Location = new Point(290, 91);
            lblTitulo.Name = "lblTitulo";
            lblTitulo.Size = new Size(57, 23);
            lblTitulo.TabIndex = 0;
            lblTitulo.Text = "Titulo";
            // 
            // lblSubtitulo
            // 
            lblSubtitulo.AutoSize = true;
            lblSubtitulo.Font = new Font("Segoe UI", 10.2F, FontStyle.Bold);
            lblSubtitulo.ForeColor = Color.FromArgb(245, 109, 95);
            lblSubtitulo.Location = new Point(264, 190);
            lblSubtitulo.Name = "lblSubtitulo";
            lblSubtitulo.Size = new Size(85, 23);
            lblSubtitulo.TabIndex = 1;
            lblSubtitulo.Text = "Subtítulo";
            // 
            // lblEnlace
            // 
            lblEnlace.AutoSize = true;
            lblEnlace.Font = new Font("Segoe UI", 10.2F, FontStyle.Bold);
            lblEnlace.ForeColor = Color.FromArgb(245, 109, 95);
            lblEnlace.Location = new Point(284, 287);
            lblEnlace.Name = "lblEnlace";
            lblEnlace.Size = new Size(60, 23);
            lblEnlace.TabIndex = 2;
            lblEnlace.Text = "Enlace";
            // 
            // lblImagen
            // 
            lblImagen.AutoSize = true;
            lblImagen.Font = new Font("Segoe UI", 10.2F, FontStyle.Bold);
            lblImagen.ForeColor = Color.FromArgb(245, 109, 95);
            lblImagen.Location = new Point(198, 385);
            lblImagen.Name = "lblImagen";
            lblImagen.Size = new Size(151, 23);
            lblImagen.TabIndex = 3;
            lblImagen.Text = "URL de la Imagen";
            // 
            // txtTitulo
            // 
            txtTitulo.BorderStyle = BorderStyle.None;
            txtTitulo.Location = new Point(381, 91);
            txtTitulo.Margin = new Padding(3, 4, 3, 4);
            txtTitulo.Name = "txtTitulo";
            txtTitulo.Size = new Size(221, 20);
            txtTitulo.TabIndex = 4;
            // 
            // txtSubtitulo
            // 
            txtSubtitulo.BorderStyle = BorderStyle.None;
            txtSubtitulo.Location = new Point(381, 189);
            txtSubtitulo.Margin = new Padding(3, 4, 3, 4);
            txtSubtitulo.Name = "txtSubtitulo";
            txtSubtitulo.Size = new Size(221, 20);
            txtSubtitulo.TabIndex = 5;
            // 
            // txtEnlace
            // 
            txtEnlace.BorderStyle = BorderStyle.None;
            txtEnlace.Location = new Point(381, 287);
            txtEnlace.Margin = new Padding(3, 4, 3, 4);
            txtEnlace.Name = "txtEnlace";
            txtEnlace.Size = new Size(221, 20);
            txtEnlace.TabIndex = 6;
            // 
            // txtImagen
            // 
            txtImagen.BorderStyle = BorderStyle.None;
            txtImagen.Location = new Point(381, 385);
            txtImagen.Margin = new Padding(3, 4, 3, 4);
            txtImagen.Name = "txtImagen";
            txtImagen.Size = new Size(221, 20);
            txtImagen.TabIndex = 7;
            // 
            // btnGuardar
            // 
            btnGuardar.BackColor = Color.FromArgb(252, 144, 139);
            btnGuardar.FlatAppearance.BorderSize = 0;
            btnGuardar.FlatStyle = FlatStyle.Flat;
            btnGuardar.Font = new Font("Segoe UI", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btnGuardar.ForeColor = Color.White;
            btnGuardar.Location = new Point(507, 470);
            btnGuardar.Margin = new Padding(3, 4, 3, 4);
            btnGuardar.Name = "btnGuardar";
            btnGuardar.Size = new Size(95, 31);
            btnGuardar.TabIndex = 8;
            btnGuardar.Text = "Guardar";
            btnGuardar.UseVisualStyleBackColor = false;
            btnGuardar.Click += btnGuardar_Click;
            // 
            // buttonLimpiar
            // 
            buttonLimpiar.BackColor = Color.FromArgb(252, 144, 139);
            buttonLimpiar.FlatAppearance.BorderSize = 0;
            buttonLimpiar.FlatStyle = FlatStyle.Flat;
            buttonLimpiar.Font = new Font("Segoe UI", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            buttonLimpiar.ForeColor = Color.White;
            buttonLimpiar.Location = new Point(381, 470);
            buttonLimpiar.Margin = new Padding(3, 4, 3, 4);
            buttonLimpiar.Name = "buttonLimpiar";
            buttonLimpiar.Size = new Size(95, 31);
            buttonLimpiar.TabIndex = 9;
            buttonLimpiar.Text = "Limpiar";
            buttonLimpiar.UseVisualStyleBackColor = false;
            buttonLimpiar.Click += buttonLimpiar_Click;
            // 
            // epArticulo
            // 
            epArticulo.ContainerControl = this;
            // 
            // CrearArticulo
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.FromArgb(253, 238, 228);
            ClientSize = new Size(914, 600);
            Controls.Add(buttonLimpiar);
            Controls.Add(btnGuardar);
            Controls.Add(txtImagen);
            Controls.Add(txtEnlace);
            Controls.Add(txtSubtitulo);
            Controls.Add(txtTitulo);
            Controls.Add(lblImagen);
            Controls.Add(lblEnlace);
            Controls.Add(lblSubtitulo);
            Controls.Add(lblTitulo);
            Margin = new Padding(3, 4, 3, 4);
            Name = "CrearArticulo";
            Text = "Crear Articulos";
            Load += CrearArticulo_Load;
            ((System.ComponentModel.ISupportInitialize)epArticulo).EndInit();
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
        private Button buttonLimpiar;
        private ErrorProvider epArticulo;
    }
}